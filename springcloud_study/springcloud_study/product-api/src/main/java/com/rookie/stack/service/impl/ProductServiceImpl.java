package com.rookie.stack.service.impl;

import com.rookie.stack.dao.ProductDao;
import com.rookie.stack.domain.Product;
import com.rookie.stack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eumenides
 * @description
 * @date 2024/6/26
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public Product findById(Long productId) {
        return productDao.findById(productId).get();
    }
}
