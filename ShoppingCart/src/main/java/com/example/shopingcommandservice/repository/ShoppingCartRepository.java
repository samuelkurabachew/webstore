package com.example.shopingcommandservice.repository;

import com.example.shopingcommandservice.domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {
}
