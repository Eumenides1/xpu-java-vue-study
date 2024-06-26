package com.rookie.stack.order.dao;

import com.rookie.stack.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author eumenides
 * @description
 * @date 2024/6/26
 */
public interface OrderDao extends JpaRepository<Order,Long> {
}
