package com.rookie.stack.xpu.dao;

import com.rookie.stack.xpu.domain.entity.Users;
import com.rookie.stack.xpu.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
@Service
public class UserDao {

    @Resource
    private UserMapper userMapper;

    public Integer insertUser(Users users){
        return userMapper.insert(users);
    }
}
