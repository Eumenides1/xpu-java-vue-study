package com.rookie.stack.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eumenides
 * @description
 * @date 2024/6/23
 */
@RestController
public class HelloWorld {
    @GetMapping("hello")
    public String hello() {
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        System.out.println("身份 :"+principal.getUsername());
        System.out.println("凭证 :"+authentication.getCredentials());
        System.out.println("权限 :"+authentication.getAuthorities());
        return "Hello World";
    }
}
