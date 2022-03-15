package com.example.shoppingqueryservice.service;

import com.example.shoppingqueryservice.domain.*;
import com.example.shoppingqueryservice.integration.OrderClient;
import com.example.shoppingqueryservice.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    //private final OrderClient orderClient;

    ShoppingCartService(ShoppingCartRepository shoppingCartRepository){
        this.shoppingCartRepository = shoppingCartRepository;
        //this.orderClient = orderClient;
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

    public boolean checkout(String cartNumber, CustomerDTO customerDTO) {
        Optional<ShoppingCart> cart = Optional.ofNullable(getCart(cartNumber));
        if(cart.isEmpty())
            return false;
        ShoppingCartDTO cartDTO = ShoppingCartAdopter.convert(cart.get());
        return true;//orderClient.createOrder(cartDTO, customerDTO) != null;
    }
}
