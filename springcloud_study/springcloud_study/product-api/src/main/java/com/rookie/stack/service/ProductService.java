package com.rookie.stack.service;

import com.rookie.stack.domain.Product;

/**
 * @author eumenides
 * @description
 * @date 2024/6/26
 */
public interface ProductService {
    Product findById(Long productId);

}
