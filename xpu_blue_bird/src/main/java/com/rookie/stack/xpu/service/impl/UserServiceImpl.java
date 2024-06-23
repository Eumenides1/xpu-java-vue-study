package com.rookie.stack.xpu.service.impl;

import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.rookie.stack.xpu.common.exception.BusinessException;
import com.rookie.stack.xpu.dao.UserDao;
import com.rookie.stack.xpu.domain.entity.Users;
import com.rookie.stack.xpu.domain.vo.req.RegisterReq;
import com.rookie.stack.xpu.service.UserService;
import com.rookie.stack.xpu.service.adapter.RegisterAdapter;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${blue-bird.secret}")
    private String secret;

    @Override
    public void register(RegisterReq req) {
        // 获取一个用户通过手机号
        Users user = userDao.getUserByPhone(req.getPhone());
        if (user != null) {
            throw new BusinessException("该用户已经存在了");
        }
        Users users = RegisterAdapter.registerReqToUser(req);
        // 对密码进行加密
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, secret.getBytes());
        users.setPassword(aes.encryptHex(req.getPassword()));

        Integer insert = userDao.insertUser(users);
        if (insert != 1) {
            throw new BusinessException("用户注册失败");
        }
    }
}
