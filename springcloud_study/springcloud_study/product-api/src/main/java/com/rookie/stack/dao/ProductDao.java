package com.rookie.stack.dao;

import com.rookie.stack.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author eumenides
 * @description
 * @date 2024/6/26
 */
public interface ProductDao extends JpaRepository<Product,Long> {

}
