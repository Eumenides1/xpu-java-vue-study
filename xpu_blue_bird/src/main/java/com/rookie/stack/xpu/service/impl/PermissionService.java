package com.rookie.stack.xpu.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import com.rookie.stack.xpu.common.context.UserContext;
import com.rookie.stack.xpu.mapper.PermissionMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author eumenides
 * @description
 * @date 2024/6/24
 */
@Component
public class PermissionService implements StpInterface {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<String> getPermissionList(Object o, String s) {
        List<String> permissionsByUserId = permissionMapper.getPermissionsByUserId((String) o);
        permissionsByUserId.forEach(System.out::println);
        return permissionsByUserId;
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        return null;
    }
}
