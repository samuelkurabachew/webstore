package webshop.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.product.domain.Product;
import webshop.product.domain.ProductStock;
import webshop.product.domain.Stock;
import webshop.product.repository.ProductRepository;
import webshop.product.repository.StockRepository;

import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductStock productStock;

    public Product getProduct(String id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        return null;

    }

    public void addProduct(Product product) {

       Optional<Product> optionalProduct = productRepository.findById(product.getProductNumber());
       if(optionalProduct.isPresent()){
           Product resultProduct = optionalProduct.get();
           resultProduct.getStock().incrementQuantity(1);
           productRepository.save(resultProduct);
       }
       else{
           Stock stock = new Stock();
           stock.setStockId(product.getProductNumber());
           product.setStock(stock);
           productRepository.insert(product);
       }
    }

    public Product updateProduct(String id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            productRepository.save(product);
            return product;
        }
        return null;
    }

    public boolean removeProduct(String id) {
        Optional<Stock> optionalStock = stockRepository.findById(id);
        if(optionalStock.isPresent()){
            Stock stock = optionalStock.get();
            if(stock.getQuantity()>0){
                stock.decrementQuantity(1);
                stockRepository.save(stock);
                return true;
            }
            return false;
        }
        return false;
    }

    public Product updateStock(String id, int quantity,String request) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            if(request == "Increment") {
                product.getStock().incrementQuantity(quantity);
                productRepository.save(product);
                return product;
            }
            else if(request == "Decrement" && product.getStock().getQuantity()>0 && product.getStock().getQuantity() >= quantity){
                product.getStock().decrementQuantity(quantity);
                productRepository.save(product);
                return product;
            }
        }
        return null;
    }

    public boolean reduceProduct(Map<String, Integer> productItem) {

        for (String productId : productItem.keySet()) {
            if(!productStock.checkProduct(productId,productItem.get(productId))){
                return false;
            }
        }
        for (String productId : productItem.keySet()) {
            productStock.changeProduct(productId,productItem.get(productId));
        }
        return true;

    }


}
