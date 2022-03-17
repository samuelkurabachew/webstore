package webstore.productservicereplica2.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import webstore.productservicereplica2.repository.ProductRepository;

import java.util.Optional;

@Component
public class ProductStock {

    @Autowired
    ProductRepository productRepository;

    public boolean checkProduct(String productId,int quantity) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent()){
            if(optionalProduct.get().getStock().getQuantity() >= quantity){
                return true;
            }
            return false;
        }
        return false;
    }

    public void changeProduct(String productId, int quantity) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.getStock().decrementQuantity(quantity);
            productRepository.save(product);
        }
    }

}
