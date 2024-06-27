package com.rookie.stack.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author eumenides
 * @description
 * @date 2024/6/27
 */
@RestController
public class SentinelController {

    @GetMapping("/sentinel")
    public String sentinel(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sentinel";
    }

    @GetMapping("/sentinel2")
    public String sentinel2(){
        return "sentinel";
    }


}
