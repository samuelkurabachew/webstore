package com.example.shopingcommandservice.domain;

public class Product {
    String productNumber;
    String productName;
    double price;
    int quantity;


    public Product(){

    }

    public Product(String productNumber, String productName, double price) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.price = price;
        this.quantity = 1;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
