package com.dyf.myblog.common.validation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmpty {

    String message();

    String[] profile() default {};
}
