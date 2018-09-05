package com.mmxin.annotation.impl;

import com.mmxin.annotation.NotEmpty;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author : mmxin
 * @className : NotEmptyValidator
 * @date : 2018/9/5 17:53
 */
public class NotEmptyValidator implements ConstraintValidator<NotEmpty, String> {

    private boolean NotNull;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
