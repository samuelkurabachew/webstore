package com.example.shopingcommandservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document
public class ShoppingCart {
    @Id
    private String cartNumber;
    private List<ProductLine> productLineList;


    public ShoppingCart(){

        productLineList = new ArrayList<>();
        cartNumber = String.valueOf(UUID.randomUUID());
    }

    public ShoppingCart(String cartNumber){
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

    public void addProductToCart(Product product){
        for(ProductLine productLine: productLineList){
            if(productLine.getProduct().getProductNumber().equals(product.getProductNumber())){
                productLine.setQuantity(productLine.getQuantity()+1);
                return;
            }
        }
        productLineList.add(new ProductLine(product, 1));
    }

    public void removeFromCart(String productNumber){
        for(ProductLine productLine: productLineList){
            if(productLine.getProduct().getProductNumber().equals(productNumber) && productLine.getQuantity() > 1){
                productLine.setQuantity(productLine.getQuantity()-1);
                return;
            }
        }
        productLineList.removeIf(product -> product.getProduct().getProductNumber().equals(productNumber));
    }
}
