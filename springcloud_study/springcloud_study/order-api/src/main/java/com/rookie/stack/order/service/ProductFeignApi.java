package com.rookie.stack.order.service;

import com.rookie.stack.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author eumenides
 * @description
 * @date 2024/6/27
 */
@FeignClient(name = "product-api")
public interface ProductFeignApi {

    @RequestMapping("/product")
    Product findById(@RequestParam("pid")Long pid);

}
