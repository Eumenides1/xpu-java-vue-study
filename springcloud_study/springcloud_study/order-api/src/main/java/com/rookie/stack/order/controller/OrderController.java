package com.rookie.stack.order.controller;

import com.rookie.stack.domain.Product;
import com.rookie.stack.order.domain.Order;
import com.rookie.stack.order.service.OrderService;
import com.rookie.stack.order.service.ProductFeignApi;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
    ProductFeignApi productFeignApi;

    @RequestMapping("getById")
    public Order getById(Long oid, Long pid) {
        Product product = productFeignApi.findById(pid);
        Order order = orderService.getById(oid, pid);
        order.setName(product.getName());
        return order;
    }
}

