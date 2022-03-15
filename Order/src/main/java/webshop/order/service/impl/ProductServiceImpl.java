package webshop.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import webshop.order.feignClient.ProductInterface;
import webshop.order.service.ProductService;

import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInterface productInterface;


    @Override
    public Boolean UpdateProductStock(Map<String,Integer> productList) {
        ResponseEntity<?> response=productInterface.updateProduct(productList);
        if(response.getStatusCode().value()==200){
            return true;
        }
        return false;
    }
}
