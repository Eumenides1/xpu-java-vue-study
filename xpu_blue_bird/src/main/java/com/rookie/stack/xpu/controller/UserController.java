package com.rookie.stack.xpu.controller;

import com.rookie.stack.xpu.common.domain.resp.ApiResult;
import com.rookie.stack.xpu.domain.vo.req.RegisterReq;
import com.rookie.stack.xpu.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        boolean register = userService.register(req);
        if (register) {
            return ApiResult.success("注册成功");
        }
        return ApiResult.fail("注册失败");
    }
}
