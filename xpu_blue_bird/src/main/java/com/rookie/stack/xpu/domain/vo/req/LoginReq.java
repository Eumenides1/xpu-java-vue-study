package com.rookie.stack.xpu.domain.vo.req;

import lombok.Data;

/**
 * @author eumenides
 * @description
 * @date 2024/6/24
 */
@Data
public class LoginReq {

    private String userNameOrPhone;

    private String password;

}
