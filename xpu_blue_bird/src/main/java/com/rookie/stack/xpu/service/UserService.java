package com.rookie.stack.xpu.service;

import com.rookie.stack.xpu.domain.vo.req.LoginReq;
import com.rookie.stack.xpu.domain.vo.req.RegisterReq;
import com.rookie.stack.xpu.domain.vo.resp.LoginSuccessResp;
import jakarta.servlet.http.HttpSession;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
public interface UserService {
    void register(RegisterReq req);

    LoginSuccessResp login(LoginReq req);

}
