package com.dyf.myblog.common.base;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertyMapping {
    String value() default "";
}
