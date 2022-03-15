package com.example.shoppingqueryservice.integration;


import com.example.shoppingqueryservice.domain.CustomerDTO;
import com.example.shoppingqueryservice.domain.ShoppingCartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("ORDERSERVICE")
public interface OrderClient {
    @PostMapping("/createorder")
    public String createOrder(ShoppingCartDTO cart, CustomerDTO customer);
}
