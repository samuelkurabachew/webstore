package webshop.order.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("shoppingCart-service")
public interface ShoppingCart {

    @GetMapping("/shoppingCart/{shoppingCartNumber}")
    Integer getStock(@PathVariable("shoppingCartNumber") String productNumber);
}
