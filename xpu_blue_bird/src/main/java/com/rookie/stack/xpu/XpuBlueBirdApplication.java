package com.rookie.stack.xpu;

import com.rookie.stack.xpu.common.filter.LoginInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan(basePackages = "com.rookie.stack.xpu.mapper")
public class XpuBlueBirdApplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(XpuBlueBirdApplication.class, args);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 使拦截器生效
        registry.addInterceptor(new LoginInterceptor());
    }
}
