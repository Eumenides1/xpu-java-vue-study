package com.rookie.stack.xpu;

import cn.dev33.satoken.SaManager;
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
        System.out.println("\n启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }
}
