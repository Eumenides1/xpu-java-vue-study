package com.rookie.stack.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * @author eumenides
 * @description
 * @date 2024/6/26
 */
//商品
@Entity(name = "t_shop_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //主键
    private Long pid;
    //商品名称
    private String name;
    //商品价格
    private Double price;
    //库存
    private Integer stock;

}

