package webshop.product.service;

import org.springframework.stereotype.Service;
import webshop.product.domain.Product;

import java.util.Map;


@Service
public interface ProductService {

    Product getProduct(String id);

    void addProduct(Product product);

    Product updateProduct(String id, Product product);

    boolean removeProduct(String id);

    Product updateStock(String id, int quantity, String request);

    boolean reduceProduct(Map<String, Integer> productItem);
}
