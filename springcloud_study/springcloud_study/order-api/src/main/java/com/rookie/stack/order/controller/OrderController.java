package com.rookie.stack.order.controller;

import com.rookie.stack.domain.Product;
import com.rookie.stack.order.domain.Order;
import com.rookie.stack.order.service.OrderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author eumenides
 * @description
 * @date 2024/6/26
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;

    @Resource
    RestTemplate restTemplate;

    @RequestMapping("getById")
    public Order getById(Long oid, Long pid) {
        String url = "http://localhost:8081/product?pid="+pid;
        System.out.println(url);
        Product product = restTemplate.getForObject(
                // 这里通过restTemplate去发起http请求，请求地址是http://localhost:8081/product，携带的参数是productId
                url, Product.class);
        Order order = orderService.getById(oid, product.getPid());
        order.setUsername(product.getName());
        return order;
    }
}

