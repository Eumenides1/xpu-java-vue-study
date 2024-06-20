package com.rookie.stack.xpu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.rookie.stack.xpu.mapper")
public class XpuBlueBirdApplication {
    public static void main(String[] args) {
        SpringApplication.run(XpuBlueBirdApplication.class, args);
    }
}
