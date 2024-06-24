package com.rookie.stack.security.service;

import com.rookie.stack.security.entity.User;
import com.rookie.stack.security.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @author eumenides
 * @description
 * @date 2024/6/23
 */
@Component
public class MyUserDetailService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);
        if (ObjectUtils.isEmpty(user)) {
            throw new RuntimeException("用户不存在");
        }
        user.setRoles(userMapper.getRolesByUid(user.getId()));
        return user;
    }
    public Boolean insertUser(User userInfo) {
        //登录的时候在 UsernamePasswordAuthenticationFilter里面解密
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return userMapper.insertUser(userInfo);
    }

}
