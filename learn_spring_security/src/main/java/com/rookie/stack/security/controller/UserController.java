package com.rookie.stack.security.controller;

import com.rookie.stack.security.entity.User;
import com.rookie.stack.security.service.MyUserDetailService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eumenides
 * @description
 * @date 2024/6/23
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private MyUserDetailService myUserDetailService;
    @PostMapping("/register")
    public Boolean register(@RequestBody User userInfo){
        return myUserDetailService.insertUser(userInfo);
    }
}
