package webstore.shoppingCartCommandService.service;

import webstore.shoppingCartCommandService.kafka.ShoppingCartEvent;
import webstore.shoppingCartCommandService.domain.Product;
import webstore.shoppingCartCommandService.domain.ShoppingCart;
import webstore.shoppingCartCommandService.repository.ShoppingCartRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    private final KafkaTemplate<String, ShoppingCartEvent> kafkaTemplate;


    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository,KafkaTemplate<String, ShoppingCartEvent> kafkaTemplate){
        this.shoppingCartRepository = shoppingCartRepository;
        this.kafkaTemplate = kafkaTemplate;
    }


    public ShoppingCart addToCart(Product product, String cartNumber){
        Optional<ShoppingCart> optionalCart;
        ShoppingCart cart;
        if(cartNumber!=null)
            optionalCart = shoppingCartRepository.findById(cartNumber);
        else
            optionalCart = Optional.empty();

        cart = optionalCart.orElseGet(ShoppingCart::new);
        cart.addProductToCart(product);
        shoppingCartRepository.save(cart);
        kafkaTemplate.send("shoppigcarttopic", new ShoppingCartEvent("ADD", product, cart.getCartNumber()));
        return cart;
    }

    public ShoppingCart removeFromCart(Product product, String cartNumber) {
        Optional<ShoppingCart> optionalCart = shoppingCartRepository.findById(cartNumber);
        ShoppingCart cart = null;
        if(optionalCart.isPresent()){
            cart = optionalCart.get();
            cart.removeFromCart(product.getProductNumber());
            shoppingCartRepository.save(cart);
            kafkaTemplate.send("shoppigcarttopic", new ShoppingCartEvent("REMOVE", product, cart.getCartNumber()));
        }
        return cart;
    }


}
