package com.rookie.stack.xpu.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import com.rookie.stack.xpu.common.domain.resp.ApiResult;
import com.rookie.stack.xpu.domain.vo.req.LoginReq;
import com.rookie.stack.xpu.domain.vo.req.RegisterReq;
import com.rookie.stack.xpu.domain.vo.resp.LoginSuccessResp;
import com.rookie.stack.xpu.service.UserService;
import com.rookie.stack.xpu.service.impl.PermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
@RestController
@RequestMapping("/v1/user")
@Tag(name = "用户相关 API")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    @Operation(
            summary = "用户注册 API"
    )
    public ApiResult<Void> register(@RequestBody @Valid RegisterReq req){
        userService.register(req);
        return ApiResult.success();
    }
    @PostMapping("/login")
    @Operation(
            summary = "用户登录 API"
    )
    public ApiResult<LoginSuccessResp> login(@RequestBody @Valid LoginReq req) {
        LoginSuccessResp resp = userService.login(req);
        return ApiResult.success(resp);
    }
    @GetMapping("/isLogin")
    @Operation(
            summary = "用户登录 API"
    )
    public ApiResult<Boolean> isLogin() {
        StpUtil.getPermissionList().forEach(System.out::println);
        return ApiResult.success(StpUtil.isLogin());
    }
}
