package com.example.shopingcommandservice;

public record ShoppingCartEvent(String event,
                                String productNumber,
                                String cartNumber) {
}
