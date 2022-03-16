package webstore.shoppingCartCommandService.service;

import webstore.shoppingCartCommandService.domain.Product;
import webstore.shoppingCartCommandService.domain.ShoppingCart;

public interface ShoppingCartService {


    ShoppingCart addToCart(Product product, String cartNumber);

    ShoppingCart removeFromCart(Product product, String cartNumber);


}
