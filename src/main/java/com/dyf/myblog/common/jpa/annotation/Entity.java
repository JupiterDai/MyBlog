package com.dyf.myblog.common.jpa.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {

    String tableName();

    String whereClause() default "";

    boolean auditColumns() default true;

}
