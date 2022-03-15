package com.example.shoppingqueryservice.integration;


import com.example.shoppingqueryservice.dto.OrderPlaceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(value = "ORDER-SERVICE")
public interface OrderClient {
    @PostMapping( value = "/order/checkout")
    ResponseEntity<String> createOrder(@RequestBody OrderPlaceDTO orderPlaceDTO);
}
