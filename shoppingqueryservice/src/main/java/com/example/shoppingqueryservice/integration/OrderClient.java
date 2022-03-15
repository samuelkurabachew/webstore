package com.example.shoppingqueryservice.integration;


import com.example.shoppingqueryservice.dto.CustomerDTO;
import com.example.shoppingqueryservice.dto.OrderPlaceDTO;
import com.example.shoppingqueryservice.dto.ShoppingCartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "ORDER-SERVICE")
public interface OrderClient {
    @PostMapping( "/createorder")
    ResponseEntity<?> createOrder(@RequestBody OrderPlaceDTO orderPlaceDTO);
}
