package com.dyf.myblog.common.utils;

import com.dyf.myblog.common.base.BaseDto;
import com.dyf.myblog.common.base.BasePO;
import com.dyf.myblog.common.base.PropertyMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dyf.myblog.common.jpa.annotation.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import org.apache.commons.lang3.SerializationUtils;

public class BeanUtils {

	public static <T> T mapFromDto(BaseDto dto, Class<T> type) throws Exception {
		if (dto != null && type != null) {
			T instance = type.getConstructor().newInstance();
			Class<?> dtoType = dto.getClass();
			Field[] dtoFields = dtoType.getDeclaredFields();
			for (Field dtoField : dtoFields) {
				Field targetField;
				String fieldName = dtoField.getName();
				if (dtoField.isAnnotationPresent(PropertyMapping.class)) {
					PropertyMapping mapping = dtoField.getAnnotation(PropertyMapping.class);
					fieldName = mapping.value();
				}
				try {
					targetField = type.getDeclaredField(fieldName);
				} catch (Exception e) {
					continue;
				}
				if (targetField.getType() == dtoField.getType()) {
					Reflections.setValue(targetField, type, instance, Reflections.getValue(dtoField, dtoType, dto));
				} else {
					if (targetField.getType() == Date.class || targetField.getType() == java.sql.Date.class) {
						String dateString = (String) Reflections.getValue(dtoField, dtoType, dto);
						if (StringUtils.isNotBlank(dateString)) {
							Reflections.setValue(targetField, type, instance, DateUtils.parseDatetime(dateString));
						}
					}
					if (targetField.getType() == int.class || targetField.getType() == Integer.class) {
						String intString = (String) Reflections.getValue(dtoField, dtoType, dto);
						if (StringUtils.isNotBlank(intString)) {
							Reflections.setValue(targetField, type, instance, Integer.parseInt(intString));
						}
					}
					if (targetField.getType() == long.class || targetField.getType() == Long.class) {
						String longString = (String) Reflections.getValue(dtoField, dtoType, dto);
						if (StringUtils.isNotBlank(longString)) {
							Reflections.setValue(targetField, type, instance, Long.parseLong(longString));
						}
					}
					if (targetField.getType() == double.class || targetField.getType() == Double.class) {
						String doubleString = (String) Reflections.getValue(dtoField, dtoType, dto);
						if (StringUtils.isNotBlank(doubleString)) {
							Reflections.setValue(targetField, type, instance, Double.parseDouble(doubleString));
						}
					}
				}
			}
			return instance;
		}
		return null;
	}

	@Deprecated
	public static <T> T mapDtoFromPO(BasePO po, Class<T> type, String dateFormat) throws Exception {
		if (StringUtils.isEmpty(dateFormat)) {
			dateFormat = "yyyy/MM/dd HH:mm:ss";
		}
		if (po != null && type != null) {
			T instance = type.getConstructor().newInstance();
			Class<?> poType = po.getClass();
			Class<?> basePoClass = poType.getSuperclass();
			Class<?> baseDtoClass = type.getSuperclass();
			Field[] fields = poType.getDeclaredFields();
			for (Field field : fields) {
				Field targetField;
				try {
					targetField = type.getDeclaredField(field.getName());
				} catch (Exception e) {
					continue;
				}
				if (field.isAnnotationPresent(NotColumn.class)) {
					continue;
				}
				if (field.getType() == Date.class) {
					Date date = (Date) Reflections.getValue(field, poType, po);
					Reflections.setValue(targetField, type, instance, DateUtils.getDateString(date, dateFormat));
				} else {
					Reflections.setValue(targetField, type, instance,
							StringUtils.getNonEmpty(String.valueOf(Reflections.getValue(field, poType, po))));
				}
			}
			Field[] auditFields = basePoClass.getDeclaredFields();
			for (Field auditField : auditFields) {
				Field dtoAuditField = baseDtoClass.getDeclaredField(auditField.getName());
				if (dtoAuditField.getType() == String.class && auditField.getType() == Date.class) {
					Date date = (Date) Reflections.getValue(auditField, basePoClass, po);
					Reflections.setValue(dtoAuditField, baseDtoClass, instance,
							DateUtils.getDateString(date, dateFormat));
				} else {
					Reflections.setValue(dtoAuditField, baseDtoClass, instance,
							StringUtils.getNonEmpty(String.valueOf(Reflections.getValue(auditField, basePoClass, po))));
				}
			}
			return instance;
		}
		return null;
	}

	public static void formatEmptyString(BasePO po) {
		if (po != null) {
			Class<?> type = po.getClass();
			Field[] fields = type.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				if (field.getType() == String.class) {
					try {
						String value = (String) Reflections.getValue(field, type, po);
						if (StringUtils.isEmpty(value)) {
							field.set(po, null);
						}
					} catch (Exception ignored) {

					}
				}
			}
		}
	}

	public static <T extends Serializable> T deepClone(T entity) {
		if (entity != null) {
			return SerializationUtils.clone(entity);
		}
		return null;
	}

	public static <T> T deepClone(T entity, Class<T> type) {
		if (entity != null) {
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				return objectMapper.readValue(objectMapper.writeValueAsString(entity), type);
			} catch (JsonProcessingException e) {
				return null;
			}
		}
		return null;
	}

}
