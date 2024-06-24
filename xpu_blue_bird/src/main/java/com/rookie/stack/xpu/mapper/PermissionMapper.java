package com.rookie.stack.xpu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rookie.stack.xpu.domain.entity.Permission;
import com.rookie.stack.xpu.domain.entity.Role;

import java.util.List;

/**
 * @author eumenides
 * @description
 * @date 2024/6/24
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    List<String> getPermissionsByUserId(String userId);
}
