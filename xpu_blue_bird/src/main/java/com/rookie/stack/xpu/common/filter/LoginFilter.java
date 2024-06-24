package com.rookie.stack.xpu.common.filter;

import cn.hutool.json.JSONUtil;
import com.rookie.stack.xpu.common.domain.resp.ApiResult;
import com.rookie.stack.xpu.domain.entity.Users;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author eumenides
 * @description
 * @date 2024/6/24
 */
@Component
public class LoginFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if ("/v1/user/login".equals(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }
        if ("/v1/user/register".equals(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }
        Users user = (Users) request.getSession().getAttribute("user");
        if (user != null) {
            filterChain.doFilter(request, response);
            return;
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
        // 将 ApiResult 对象转换为 JSON 字符串
        String jsonResponse = JSONUtil.toJsonStr(apiResult);

        PrintWriter out = response.getWriter();
        // 设置响应内容，结束请求
        out.write(jsonResponse);
        out.flush();
        out.close();
    }
}
