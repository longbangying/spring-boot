package com.xbang.commons.validate.support;


import com.xbang.commons.validate.annotation.IdCard;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 验证自定义注解的处理类
 */
public class IdCardValidator implements ConstraintValidator<IdCard,Object> {

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(null == o){
            return false;
        }

        String idCard = o.toString();
        if("123".equals(idCard)){
            return true;
        }
        return false;
    }

    @Override
    public void initialize(IdCard constraintAnnotation) {

    }
}
