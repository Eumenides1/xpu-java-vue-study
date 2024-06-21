package com.rookie.stack.xpu.domain.vo.req;

import lombok.Data;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
@Data
public class RegisterReq {

    private String userName;

    private String password;

    private String retryPassword;

    private String phone;
}
