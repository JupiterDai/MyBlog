package com.dyf.myblog.common.jpa.exec;



import com.dyf.myblog.common.*;
import com.dyf.myblog.common.base.BasePO;
import com.dyf.myblog.common.utils.BeanUtils;
import com.dyf.myblog.common.utils.SpringUtils;

import java.util.Date;

public class JPAExecutor {

    private static final IExecutor executor = SpringUtils.getBean(IExecutor.class);

    public static void save(BasePO entity) {
        if (entity != null) {
            Date now = new Date();
            AppContext appContext = AppContext.getFromWebThread();
            entity.setCreatedAt(now);
            entity.setUpdatedAt(now);
            entity.setCreatedBy(appContext.getUserName());
            entity.setUpdatedBy(appContext.getUserName());
            BeanUtils.formatEmptyString(entity);
            executor.insert(entity);
        }
    }

    public static void update(BasePO entity) {
        if (entity != null) {
            Date now = new Date();
            AppContext appContext = AppContext.getFromWebThread();
            entity.setUpdatedAt(now);
            entity.setUpdatedBy(appContext.getUserName());
            BeanUtils.formatEmptyString(entity);
            executor.update(entity);
        }
    }

    public static void delete(BasePO entity) {
        if (entity != null) {
            executor.delete(entity);
        }
    }
}
