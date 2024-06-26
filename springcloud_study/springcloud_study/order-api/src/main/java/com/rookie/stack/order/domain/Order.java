package com.rookie.stack.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

/**
 * @author eumenides
 * @description
 * @date 2024/6/26
 */
//订单
@Entity(name = "t_shop_order")
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //订单id
    private Long oid;

    //用户id
    private Long uid;
    //用户名
    private String username;
    //商品id
    private Long pid;
    //商品名称
    private String name;
    //商品单价
    private Double price;
    //购买数量
    private Integer number;
}

