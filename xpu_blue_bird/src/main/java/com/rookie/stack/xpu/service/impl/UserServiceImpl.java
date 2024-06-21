package com.rookie.stack.xpu.service.impl;

import com.rookie.stack.xpu.dao.UserDao;
import com.rookie.stack.xpu.domain.entity.Users;
import com.rookie.stack.xpu.domain.vo.req.RegisterReq;
import com.rookie.stack.xpu.service.UserService;
import com.rookie.stack.xpu.service.adapter.RegisterAdapter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author eumenides
 * @description
 * @date 2024/6/21
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public boolean register(RegisterReq req) {
        if (!Objects.equals(req.getPassword(), req.getRetryPassword())){
            // TODO 抛出一个异常
            return false;
        }
        // TODO 正则校验手机号，邮箱
        Users users = RegisterAdapter.registerReqToUser(req);
        Integer insert = userDao.insertUser(users);

        return insert == 1;
    }
}
