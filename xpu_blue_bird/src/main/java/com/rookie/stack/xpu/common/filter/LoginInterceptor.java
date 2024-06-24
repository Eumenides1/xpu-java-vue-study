package com.rookie.stack.xpu.common.filter;

import cn.hutool.json.JSONUtil;
import com.rookie.stack.xpu.common.context.UserContext;
import com.rookie.stack.xpu.common.domain.resp.ApiResult;
import com.rookie.stack.xpu.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;

/**
 * @author eumenides
 * @description
 * @date 2024/6/24
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if ("/v1/user/login".equals(request.getRequestURI())) {
            return true;
        }
        if ("/v1/user/register".equals(request.getRequestURI())) {
            return true;
        }

        Claims authorization = JwtUtil.parse(request.getHeader("Authorization"));
        if (authorization != null) {
            UserContext.add(authorization.getSubject());
            return true;
        }
        // 走到这里就代表是其他接口，且没有登录
        // 设置响应数据类型为json（前后端分离）
        response.setContentType("application/json;charset=utf-8");
        // 构建 ApiResult 对象
        ApiResult<Void> apiResult = new ApiResult<>();
        // 未授权
        apiResult.setCode(HttpStatus.UNAUTHORIZED.value());
        apiResult.setMessage("请先登录");
        apiResult.setSuccess(false);
        apiResult.setData(null);
        String jsonResponse = JSONUtil.toJsonStr(apiResult);

        // 设置响应内容，结束请求
        PrintWriter out = response.getWriter();
        out.write(jsonResponse);
        out.flush();
        out.close();

        return false;
    }
}
