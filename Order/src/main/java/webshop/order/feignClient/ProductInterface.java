package webshop.order.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;


import java.util.Map;

@FeignClient("product-service")
public interface ProductInterface {

    @PutMapping("/api/v1/product/reduce")
    ResponseEntity<?> updateProduct(Map<String,Integer> productList);
}
