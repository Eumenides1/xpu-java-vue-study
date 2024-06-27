package com.rookie.stack.order.service.impl;

import com.rookie.stack.domain.Product;
import com.rookie.stack.order.dao.OrderDao;
import com.rookie.stack.order.domain.Order;
import com.rookie.stack.order.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 * @author eumenides
 * @description
 * @date 2024/6/26
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderDao orderDao;

    @Resource
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Order getById(Long oid, Long pid) {
        Order one = orderDao.getOne(oid);
        return one;
    }
}


