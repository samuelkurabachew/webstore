package webstore.shoppingCartCommandService.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import webstore.shoppingCartCommandService.error.CustomErrorType;
import webstore.shoppingCartCommandService.service.ShoppingCartService;
import webstore.shoppingCartCommandService.domain.Product;
import webstore.shoppingCartCommandService.domain.ShoppingCart;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shoppingcartscommand")
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;
    private static final Logger log = LoggerFactory.getLogger(ShoppingCartController.class);

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
        log.info("SHOPPING CART COMMAND - ADD CART WITH CART NUMBER: " + cartNumber + " AND PRODUCT: " + product);
        try{
            ShoppingCart cart = shoppingCartService.addToCart(product, cartNumber);
            return new ResponseEntity<>(cart, HttpStatus.ACCEPTED);
        }catch (Exception ex){
            return new ResponseEntity<>(getCustomErrorType("Sorry, Cannot add to cart"),HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> addToCart(@RequestBody Product product){
        log.info("SHOPPING CART COMMAND - ADD TO CART: "+ product);
        try{
            ShoppingCart cart = shoppingCartService.addToCart(product, null);
            return new ResponseEntity<>(cart, HttpStatus.ACCEPTED);
        }catch (Exception ex){
            return new ResponseEntity<>(getCustomErrorType("Sorry, Cannot add to cart"),HttpStatus.OK);
        }
    }

    @PutMapping("/{cartNumber}/remove")
    public ResponseEntity<?> removeFromCart(@RequestBody Product product, @PathVariable String cartNumber){
        log.info("SHOPPING CART COMMAND - REMOVE FROM CART: "+ product);
        try{
            ShoppingCart cart = shoppingCartService.removeFromCart(product, cartNumber);
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(getCustomErrorType("Sorry, Cannot remove from cart"),HttpStatus.OK);
        }
    }

    public CustomErrorType getCustomErrorType(String message){
        return new CustomErrorType(message);
    }


}
