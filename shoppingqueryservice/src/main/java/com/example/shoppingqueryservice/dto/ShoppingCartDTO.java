package com.example.shoppingqueryservice.dto;

import com.example.shoppingqueryservice.domain.ProductLine;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingCartDTO {
    private String cartNumber;
    private List<ProductLine> productLineList;


    public ShoppingCartDTO(){

        productLineList = new ArrayList<>();
        cartNumber = String.valueOf(UUID.randomUUID());
    }

    public ShoppingCartDTO(String cartNumber){
        this.cartNumber = cartNumber;
        productLineList = new ArrayList<>();
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }

    public List<ProductLine> getProductLineList() {
        return productLineList;
    }

    public void setProductLineList(List<ProductLine> productLineList) {
        this.productLineList = productLineList;
    }
}
