package webstore.shoppingCartQueryService.controller;

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

    ShoppingCartController(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }


    @GetMapping("/{cartNumber}")
    public ResponseEntity<?> getCart(@PathVariable String cartNumber){
        ShoppingCart shoppingCart = shoppingCartService.getCart(cartNumber);
        if(shoppingCart == null)
            return new ResponseEntity<>(getCustomErrorType("Sorry, cart not found"),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
    }

    @PostMapping("/{cartNumber}/checkout")
    public ResponseEntity<?> checkout(@PathVariable String cartNumber, @RequestBody CustomerDTO customer){
        if(shoppingCartService.checkout(cartNumber, customer))
            return new ResponseEntity<>(getCustomErrorType("Sorry, Cannot checkout the cart"),HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public CustomErrorType getCustomErrorType(String message){
        return new CustomErrorType(message);
    }


}
