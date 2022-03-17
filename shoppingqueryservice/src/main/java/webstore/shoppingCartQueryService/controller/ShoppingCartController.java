package webstore.shoppingCartQueryService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webstore.shoppingCartQueryService.dto.CustomerDTO;
import webstore.shoppingCartQueryService.domain.ShoppingCart;
import webstore.shoppingCartQueryService.error.CustomErrorType;
import webstore.shoppingCartQueryService.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shoppingcartsquery")
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;
    private static final Logger log = LoggerFactory.getLogger(ShoppingCartController.class);

    ShoppingCartController(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }


    @GetMapping("/{cartNumber}")
    public ResponseEntity<?> getCart(@PathVariable String cartNumber){
        log.info("SHOPPING CART QUERY - GET CART: "+ cartNumber);
        ShoppingCart shoppingCart = shoppingCartService.getCart(cartNumber);
        if(shoppingCart == null)
            return new ResponseEntity<>(getCustomErrorType("Sorry, cart not found"),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
    }

    @PostMapping("/{cartNumber}/checkout")
    public ResponseEntity<?> checkout(@PathVariable String cartNumber, @RequestBody CustomerDTO customer){
        log.info("SHOPPING CART QUERY - CHECKOUT: " + cartNumber);
        return shoppingCartService.checkout(cartNumber, customer);
    }

    public CustomErrorType getCustomErrorType(String message){
        return new CustomErrorType(message);
    }


}
