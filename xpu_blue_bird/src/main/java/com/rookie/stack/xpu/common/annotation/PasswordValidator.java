package com.rookie.stack.xpu.common.annotation;

import com.rookie.stack.xpu.domain.vo.req.RegisterReq;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
public class PasswordValidator implements ConstraintValidator<PasswordEqual, RegisterReq> {
    @Override
    public boolean isValid(RegisterReq req, ConstraintValidatorContext constraintValidatorContext) {
        if (req == null) {
            return false;
        }
        if (!Objects.equals(req.getPassword(), req.getRetryPassword())) {
            return false;
        }
        return true;
    }
}
