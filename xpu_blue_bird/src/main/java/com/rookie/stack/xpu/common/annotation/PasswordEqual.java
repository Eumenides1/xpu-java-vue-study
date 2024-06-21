package com.rookie.stack.xpu.common.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordValidator.class )
public @interface PasswordEqual {

    String message() default "两次密码不匹配";

    // groups和payload方法是注解中必须要有的两个方法
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
