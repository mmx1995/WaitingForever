package com.mmxin.annotation;

import com.mmxin.annotation.impl.NotEmptyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : mmxin
 * @className : notEmpty
 * @date : 2018/9/5 17:51
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEmptyValidator.class)
public @interface NotEmpty {

    String message() default "不允许为空";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public abstract boolean NotNull() default true;

}
