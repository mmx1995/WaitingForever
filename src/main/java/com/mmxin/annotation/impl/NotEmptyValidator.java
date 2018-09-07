package com.mmxin.annotation.impl;

import com.mmxin.annotation.NotEmpty;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author : mmxin
 * @className : NotEmptyValidator
 * @date : 2018/9/5 17:53
 * 注解，不允许为空
 */
public class NotEmptyValidator implements ConstraintValidator<NotEmpty, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(null == s || "".equals(s)){
            return false ;
        }
        return true;
    }
}
