package com.example.shoppingqueryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class ShoppingqueryserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingqueryserviceApplication.class, args);
    }

}
