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

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final OrderClient orderClient;

    ShoppingCartService(ShoppingCartRepository shoppingCartRepository, OrderClient orderClient){
        this.shoppingCartRepository = shoppingCartRepository;
        this.orderClient = orderClient;
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
        OrderPlaceDTO orderPlaceDTO = new OrderPlaceDTO(customerDTO,cartDTO);
        return orderClient.createOrder(orderPlaceDTO) != null;
    }
}
