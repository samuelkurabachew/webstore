package com.example.shopingcommandservice;

import com.example.shopingcommandservice.domain.Product;

public record ShoppingCartEvent(String event,
                                Product product,
                                String cartNumber) {
}
