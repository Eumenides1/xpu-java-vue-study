package com.rookie.stack.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rookie.stack.security.entity.Role;
import com.rookie.stack.security.entity.User;

import java.util.List;

/**
 * @author eumenides
 * @description
 * @date 2024/6/23
 */
public interface UserMapper extends BaseMapper<User> {
    //根据用户名查询用户
    User loadUserByUsername(String username);

    //根据用户id查询角色
    List<Role> getRolesByUid(Integer uid);

    boolean insertUser(User user);
}
