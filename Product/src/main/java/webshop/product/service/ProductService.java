package webshop.product.service;

import webshop.product.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getAllProduct();

    Product getProduct(String id);

    void addProduct(Product product);

    Product updateProduct(String id, Product product);

    boolean removeProduct(String id);

    boolean updateStock(String id, int quantity, String request);

    boolean reduceProduct(Map<String, Integer> productItem);

}
