package com.example.shopingcommandservice.service;

import com.example.shopingcommandservice.ShoppingCartEvent;
import com.example.shopingcommandservice.repository.ShoppingCartRepository;
import com.example.shopingcommandservice.domain.Product;
import com.example.shopingcommandservice.domain.ShoppingCart;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    private final KafkaTemplate<String, ShoppingCartEvent> kafkaTemplate;


    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository,KafkaTemplate<String, ShoppingCartEvent> kafkaTemplate){
        this.shoppingCartRepository = shoppingCartRepository;
        this.kafkaTemplate = kafkaTemplate;
    }


    public ShoppingCart addToCart(Product product, String cartNumber){
        Optional<ShoppingCart> optionalCart;
        ShoppingCart cart;
        if(cartNumber!=null)
            optionalCart = shoppingCartRepository.findById(cartNumber);
        else
            optionalCart = Optional.empty();

        cart = optionalCart.orElseGet(ShoppingCart::new);
        cart.addProductToCart(product);
        shoppingCartRepository.save(cart);
        kafkaTemplate.send("shoppigcarttopic", new ShoppingCartEvent("ADDED TO CART", product.getProductNumber(), cart.getCartNumber()));
        return cart;
    }

    public ShoppingCart removeFromCart(Product product, String cartNumber) {
        Optional<ShoppingCart> optionalCart = shoppingCartRepository.findById(cartNumber);
        ShoppingCart cart = null;
        if(optionalCart.isPresent()){
            cart = optionalCart.get();
            cart.removeFromCart(product.getProductNumber());
            shoppingCartRepository.save(cart);
            kafkaTemplate.send("shoppigcarttopic", new ShoppingCartEvent("REMOVED FROM CART", product.getProductNumber(), cart.getCartNumber()));
        }
        return cart;
    }


    public ShoppingCart getCart(String cartNumber) {
        return shoppingCartRepository.findById(cartNumber).orElse(null);
    }

}
