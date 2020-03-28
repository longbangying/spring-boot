package com.xbang.mvc.annotation.support;

import com.xbang.mvc.annotation.IdCard;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdCardValidator implements ConstraintValidator<IdCard,Object> {

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
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
