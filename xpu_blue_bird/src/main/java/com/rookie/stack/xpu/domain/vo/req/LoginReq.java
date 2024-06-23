package com.rookie.stack.xpu.domain.vo.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author eumenides
 * @description
 * @date 2024/6/23
 */
@Data
public class LoginReq {
    @NotBlank
    private String userNameOrPhone;
    @NotBlank
    private String password;

}
