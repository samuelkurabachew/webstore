package com.example.shoppingqueryservice.service;

import com.example.shoppingqueryservice.repository.ShoppingCartRepository;
import com.example.shoppingqueryservice.domain.Product;
import com.example.shoppingqueryservice.domain.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    ShoppingCartService(ShoppingCartRepository shoppingCartRepository){
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public void addToCart(Product product, String cartNumber){
        Optional<ShoppingCart> optionalCart;
        ShoppingCart cart;
        if(cartNumber!=null)
            optionalCart = shoppingCartRepository.findById(cartNumber);
        else
            optionalCart = Optional.empty();

        cart = optionalCart.orElseGet(ShoppingCart::new);

        cart.setCartNumber(cartNumber);
        cart.addProductToCart(product);
        shoppingCartRepository.save(cart);

        cart = shoppingCartRepository.findById(cartNumber).get();
    }

    public void removeFromCart(Product product, String cartNumber) {
        Optional<ShoppingCart> optionalCart = shoppingCartRepository.findById(cartNumber);
        ShoppingCart cart = null;
        if(optionalCart.isPresent()){
            cart = optionalCart.get();
            cart.removeFromCart(product.getProductNumber());
            shoppingCartRepository.save(cart);
        }
    }


    public ShoppingCart getCart(String cartNumber) {
        return shoppingCartRepository.findById(cartNumber).orElse(null);
    }

}
