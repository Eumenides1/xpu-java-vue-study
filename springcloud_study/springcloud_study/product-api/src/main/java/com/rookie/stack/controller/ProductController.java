package com.rookie.stack.controller;

import com.rookie.stack.domain.Product;
import com.rookie.stack.service.ProductService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eumenides
 * @description
 * @date 2024/6/26
 */
@RestController
@Slf4j
public class ProductController {
    @Resource
    private ProductService productService;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("test")
    public void test(){
        ServiceInstance serviceInstance = discoveryClient.getInstances("product-api").get(0);
        System.out.println(serviceInstance.getHost());
    }
    //商品信息查询
    @GetMapping("/product")
    public Product findByPid(@RequestParam("pid") Long pid) {
        Product product = productService.findById(pid);
        return product;
    }
}
