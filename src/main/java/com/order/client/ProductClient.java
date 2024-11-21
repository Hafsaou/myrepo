package com.order.client;

import com.order.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name = "order-service", url = "http://localhost:8081/product")
public interface ProductClient {

    @GetMapping("/all")
   List<Product> getAllProducts();
}
