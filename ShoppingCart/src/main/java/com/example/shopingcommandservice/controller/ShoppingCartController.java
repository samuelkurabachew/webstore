package com.example.shopingcommandservice.controller;

import com.example.shopingcommandservice.service.ShoppingCartService;
import com.example.shopingcommandservice.domain.Product;
import com.example.shopingcommandservice.domain.ShoppingCart;
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


//    @GetMapping("/{cartNumber}")
//    public ResponseEntity<?> getCart(@PathVariable String cartNumber){
//        ShoppingCart shoppingCart = shoppingCartService.getCart(cartNumber);
//        if(shoppingCart == null)
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
//    }

    @PutMapping("/{cartNumber}/add")
    public ResponseEntity<?> addToCart(@RequestBody Product product, @PathVariable String cartNumber){
        ShoppingCart cart = shoppingCartService.addToCart(product, cartNumber);
        return new ResponseEntity<>(cart, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> addToCart(@RequestBody Product product){
        ShoppingCart cart = shoppingCartService.addToCart(product, null);
        return new ResponseEntity<>(cart, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{cartNumber}/remove")
    public ResponseEntity<?> removeFromCart(@RequestBody Product product, @PathVariable String cartNumber){
        ShoppingCart cart = shoppingCartService.removeFromCart(product, cartNumber);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }


}
