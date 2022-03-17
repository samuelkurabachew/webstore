package webstore.productservicereplica2.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webstore.productservicereplica2.domain.Product;
import webstore.productservicereplica2.domain.ProductStock;
import webstore.productservicereplica2.domain.Stock;
import webstore.productservicereplica2.repository.ProductRepository;
import webstore.productservicereplica2.repository.StockRepository;
import webstore.productservicereplica2.service.ProductService;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductStock productStock;

    @Override
    public Product getProduct(String id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        return null;

    }

    @Override
    public void addProduct(Product product) {

        if(Objects.nonNull(product.getProductNumber())){
            Optional<Product> optionalProduct = productRepository.findById(product.getProductNumber());
            if(optionalProduct.isPresent()){
                Product resultProduct = optionalProduct.get();
                resultProduct.getStock().incrementQuantity(1);
                productRepository.save(resultProduct);
            }
        }
       else{
           Product p = productRepository.save(product);
           Stock stock = new Stock();
           stock.setStockId(product.getProductNumber());
           p.setStock(stock);
            productRepository.save(p);
       }
    }

    @Override
    public Product updateProduct(String id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            Product fetchedProduct = optionalProduct.get();
            fetchedProduct.setName(product.getName());
            fetchedProduct.setPrice(product.getPrice());
            fetchedProduct.setDescription(product.getDescription());

            productRepository.save(fetchedProduct);
            return fetchedProduct;
        }
        return null;
    }

    @Override
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

    @Override
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

    @Override
    @SneakyThrows
    @HystrixCommand(fallbackMethod = "productFallBack")
    public boolean reduceProduct(Map<String, Integer> productItem) {
        Thread.sleep(1000);
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

    public boolean productFallBack(Map<String, Integer> productItem) {
        return false;
    }
}
