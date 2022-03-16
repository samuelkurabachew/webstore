package webshop.order.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import webshop.order.dto.CustomerDTO;
import webshop.order.entity.Customer;

import java.util.Map;

@FeignClient("product-service")
public interface ProductInterface {
    @PostMapping("/product/reduce")
    ResponseEntity<?> updateProduct(Map<String,Integer> productList);
}
