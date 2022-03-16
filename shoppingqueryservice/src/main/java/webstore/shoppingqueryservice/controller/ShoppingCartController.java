package webstore.shoppingqueryservice.controller;

import webstore.shoppingqueryservice.domain.CustomerDTO;
import webstore.shoppingqueryservice.domain.ShoppingCart;
import webstore.shoppingqueryservice.service.ShoppingCartService;
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

    @PostMapping("/{cartNumber}/checkout")
    public ResponseEntity<?> checkout(@PathVariable String cartNumber, @RequestBody CustomerDTO customer){
        if(shoppingCartService.checkout(cartNumber, customer))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }



}
