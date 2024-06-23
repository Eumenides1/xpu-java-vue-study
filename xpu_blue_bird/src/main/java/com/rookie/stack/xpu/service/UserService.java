package com.rookie.stack.xpu.service;

import com.rookie.stack.xpu.domain.vo.req.LoginReq;
import com.rookie.stack.xpu.domain.vo.req.RegisterReq;
import jakarta.servlet.http.HttpSession;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
public interface UserService {
    void register(RegisterReq req);

    void login(LoginReq req, HttpSession session);
}
