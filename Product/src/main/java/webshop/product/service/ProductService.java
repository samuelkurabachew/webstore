package webshop.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.product.domain.Product;
import webshop.product.domain.Stock;
import webshop.product.repository.StockRepository;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    StockRepository stockRepository;

    public Stock getProduct(String id){
        Optional<Stock> optionalStock = stockRepository.findById(id);
        if(optionalStock.isPresent()){
            return optionalStock.get();
        }
        return null;

    }

    public void addProduct(Product product) {

       Optional<Stock> optionalStock = stockRepository.findById(product.getProductNumber());
       if(optionalStock.isPresent()){
           Stock stock = optionalStock.get();
           stock.incrementQuantity(1);
           stockRepository.save(stock);
       }
       else{
           Stock stock = new Stock();
           stock.setStockId(product.getProductNumber());
           stock.setProduct(product);
           stockRepository.insert(stock);
       }
    }

    public Stock updateProduct(String id, Product product) {
        Optional<Stock> optionalStock = stockRepository.findById(id);
        if(optionalStock.isPresent()){
            Stock stock = optionalStock.get();
            stock.setProduct(product);
            stockRepository.save(stock);
            return stock;
        }
        return null;
    }

    public boolean removeProduct(String id) {
        Optional<Stock> optionalStock = stockRepository.findById(id);
        if(optionalStock.isPresent()){
            stockRepository.deleteById(id);
            return true;
        }
        return false;
    }

    boolean checkProduct(Product product) {
        Optional<Stock> optionalStock = stockRepository.findById(product.getProductNumber());
        return optionalStock.isPresent();
    }
}
