package com.rookie.stack.xpu.common.context;

import com.rookie.stack.xpu.domain.entity.Users;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author eumenides
 * @description
 * @date 2024/6/24
 */
public class RequestContext {
    public static HttpServletRequest getCurrentRequest() {
        return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
    }
    public static Users getCurrentUser() {
        // 通过request对象获取session对象，再获取当前用户对象
        return (Users)getCurrentRequest().getSession().getAttribute("user");
    }
}
