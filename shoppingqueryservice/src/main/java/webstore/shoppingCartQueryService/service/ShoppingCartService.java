package webstore.shoppingCartQueryService.service;

import org.springframework.http.ResponseEntity;
import webstore.shoppingCartQueryService.domain.Product;
import webstore.shoppingCartQueryService.dto.CustomerDTO;
import webstore.shoppingCartQueryService.domain.ShoppingCart;


public interface ShoppingCartService {

     void addToCart(Product product, String cartNumber);

     void removeFromCart(Product product, String cartNumber);

     ShoppingCart getCart(String cartNumber);

     ResponseEntity<?> checkout(String cartNumber, CustomerDTO customerDTO);
}
