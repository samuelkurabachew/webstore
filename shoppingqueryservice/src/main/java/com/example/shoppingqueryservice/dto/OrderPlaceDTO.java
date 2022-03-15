package com.example.shoppingqueryservice.dto;

import org.aspectj.weaver.ast.Or;

public class OrderPlaceDTO {
    CustomerDTO customerDTO;
    ShoppingCartDTO shoppingCartDTO;

    public OrderPlaceDTO(){

    }

    public OrderPlaceDTO(CustomerDTO customerDTO, ShoppingCartDTO shoppingCartDTO) {
        this.customerDTO = customerDTO;
        this.shoppingCartDTO = shoppingCartDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public ShoppingCartDTO getShoppingCartDTO() {
        return shoppingCartDTO;
    }
}
