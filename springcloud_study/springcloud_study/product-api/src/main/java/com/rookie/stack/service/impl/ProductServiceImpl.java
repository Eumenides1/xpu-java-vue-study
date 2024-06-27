package com.rookie.stack.service.impl;

import com.rookie.stack.dao.ProductDao;
import com.rookie.stack.domain.Product;
import com.rookie.stack.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author eumenides
 * @description
 * @date 2024/6/26
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductDao productDao;

    @Value("${server.port}")
    private String port;

    @Override
    public Product findById(Long productId) {
        Product product = productDao.findById(productId).get();
        product.setName(product.getName() + " product data from" + port);
        return product;
    }
}
