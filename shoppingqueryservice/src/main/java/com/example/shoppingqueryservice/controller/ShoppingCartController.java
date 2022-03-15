package com.example.shoppingqueryservice.controller;

import com.example.shoppingqueryservice.domain.ShoppingCart;
import com.example.shoppingqueryservice.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shoppingcarts")
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;

    ShoppingCartController(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }


    @GetMapping("/{cartNumber}")
    public ResponseEntity<?> getCart(@PathVariable String cartNumber){
        ShoppingCart shoppingCart = shoppingCartService.getCart(cartNumber);
        if(shoppingCart == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
    }


}
