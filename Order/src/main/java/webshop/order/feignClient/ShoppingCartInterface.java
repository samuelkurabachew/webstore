package webshop.order.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import webshop.order.entity.ShoppingCart;

@FeignClient("shoppingCart-service")
public interface ShoppingCartInterface {

    @GetMapping("/shoppingCart/{shoppingCartNumber}")
    ShoppingCart getShoppingcart(@PathVariable("shoppingCartNumber") String shoppingCartNumber);
}
