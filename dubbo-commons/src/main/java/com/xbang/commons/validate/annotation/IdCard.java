package com.xbang.commons.validate.annotation;


import com.xbang.commons.validate.support.IdCardValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdCardValidator.class)
public @interface IdCard {
    //定制化提示信息，
    String message() default "身份证号码不合法";

    Class<?> [] groups() default {};

    Class<? extends Payload> [] payload() default {};
}
