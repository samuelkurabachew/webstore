package webstore.shoppingCartQueryService.service;

import webstore.shoppingCartQueryService.domain.Product;
import webstore.shoppingCartQueryService.domain.ShoppingCartAdopter;
import webstore.shoppingCartQueryService.dto.CustomerDTO;
import webstore.shoppingCartQueryService.dto.OrderPlaceDTO;
import webstore.shoppingCartQueryService.dto.ShoppingCartDTO;
import webstore.shoppingCartQueryService.integration.OrderClient;
import webstore.shoppingCartQueryService.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;
import webstore.shoppingCartQueryService.domain.ShoppingCart;

import java.util.Optional;

public interface ShoppingCartService {


     void addToCart(Product product, String cartNumber);

     void removeFromCart(Product product, String cartNumber);

     ShoppingCart getCart(String cartNumber);

     boolean checkout(String cartNumber, CustomerDTO customerDTO);
}
