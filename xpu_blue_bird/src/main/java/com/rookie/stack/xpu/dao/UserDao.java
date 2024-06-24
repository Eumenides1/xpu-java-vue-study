package com.rookie.stack.xpu.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rookie.stack.xpu.common.enums.UserStatusEnum;
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

    public Users getUserByPhone(String phone){
        // QueryWrapper 条件构造器
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        queryWrapper.ne("status",UserStatusEnum.DELETED.getCode());
        return userMapper.selectOne(queryWrapper);
    }

    public Users getUserByUserNameOrPhone(String userNameOrPhone) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userNameOrPhone)
                .or()
            .eq("phone", userNameOrPhone);
        queryWrapper.ne("status",UserStatusEnum.DELETED.getCode());
        return userMapper.selectOne(queryWrapper);
    }

}
