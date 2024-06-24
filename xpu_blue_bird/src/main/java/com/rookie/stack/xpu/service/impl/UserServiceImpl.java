package com.rookie.stack.xpu.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.rookie.stack.xpu.common.exception.BusinessException;
import com.rookie.stack.xpu.common.utils.JwtUtil;
import com.rookie.stack.xpu.dao.UserDao;
import com.rookie.stack.xpu.domain.entity.Users;
import com.rookie.stack.xpu.domain.vo.req.LoginReq;
import com.rookie.stack.xpu.domain.vo.req.RegisterReq;
import com.rookie.stack.xpu.domain.vo.resp.LoginSuccessResp;
import com.rookie.stack.xpu.service.UserService;
import com.rookie.stack.xpu.service.adapter.RegisterAdapter;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
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
        users.setPassword(encryptPassword(req.getPassword()));
        Integer insert = userDao.insertUser(users);
        // TODO 设置用户角色
        if (insert != 1) {
            throw new BusinessException("用户注册失败");
        }
    }

    @Override
    public LoginSuccessResp login(LoginReq req) {
        // 首先先去数据库里查询用户，看看用户是否存在
        Users user = userDao.getUserByUserNameOrPhone(req.getUserNameOrPhone());
        if (user == null) {
            throw new BusinessException("该用户不存在");
        }
        String password = decryptPassword(user.getPassword());
        if (!Objects.equals(password, req.getPassword())) {
            throw new BusinessException("密码不正确，请确认后重试");
        }
        LoginSuccessResp resp = new LoginSuccessResp();
        // 密码校验成功后登录，一行代码实现登录
        StpUtil.login(user.getUserId());
        // 获取当前登录用户Token信息
        SaTokenInfo saTokenInfo = StpUtil.getTokenInfo();
        resp.setSaTokenInfo(saTokenInfo);
        return resp;
    }

    private String encryptPassword(String password) {
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, secret.getBytes());
        return aes.encryptHex(password);
    }

    private String decryptPassword(String encryptedPassword) {
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, secret.getBytes());
        return aes.decryptStr(encryptedPassword, CharsetUtil.CHARSET_UTF_8);
    }
}
