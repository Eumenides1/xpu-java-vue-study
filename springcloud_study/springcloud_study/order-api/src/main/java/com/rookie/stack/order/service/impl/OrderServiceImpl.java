package com.rookie.stack.order.service.impl;

import com.rookie.stack.order.dao.OrderDao;
import com.rookie.stack.order.domain.Order;
import com.rookie.stack.order.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eumenides
 * @description
 * @date 2024/6/26
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderDao orderDao;

    @Override
    public Order getById(Long oid, Long pid) {
        return orderDao.getOne(oid);
    }
}


