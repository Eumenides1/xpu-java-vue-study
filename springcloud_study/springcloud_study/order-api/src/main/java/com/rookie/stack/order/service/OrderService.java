package com.rookie.stack.order.service;

import com.rookie.stack.order.domain.Order;

/**
 * @author eumenides
 * @description
 * @date 2024/6/26
 */
public interface OrderService {
    Order getById(Long oid, Long pid);
}


