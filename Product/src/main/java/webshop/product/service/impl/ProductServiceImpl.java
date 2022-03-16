package webshop.product.service.impl;

import org.springframework.stereotype.Service;
import webshop.product.domain.Product;
import webshop.product.domain.ProductStock;
import webshop.product.domain.Stock;
import webshop.product.repository.ProductRepository;
import webshop.product.repository.StockRepository;
import webshop.product.service.ProductService;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final StockRepository stockRepository;

    private final ProductRepository productRepository;

    private final ProductStock productStock;

    public ProductServiceImpl(StockRepository stockRepository,
                              ProductRepository productRepository,
                              ProductStock productStock) {
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
        this.productStock = productStock;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        return null;

    }

    @Override
    public void addProduct(Product product) {
        if(Objects.nonNull(product.getProductNumber())){
            Optional<Product> optionalProduct = productRepository.findById(product.getProductNumber());
            if (optionalProduct.isPresent()) {
                Product resultProduct = optionalProduct.get();
                resultProduct.getStock().incrementQuantity(1);
                productRepository.save(resultProduct);
            }
        }
      else {
            Stock stock = new Stock();
            stock.setStockId(product.getProductNumber());
            product.setStock(stock);
            product.setStatus('Y');
            productRepository.insert(product);
        }
    }

    @Override
    public Product updateProduct(String id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            productRepository.save(product);
            return product;
        }
        return null;
    }

    @Override
    public boolean removeProduct(String id) {
        Optional<Stock> optionalStock = stockRepository.findById(id);
        Optional<Product> exisitingProduct = productRepository.findById(id);
        if (optionalStock.isPresent()) {
            Stock stock = optionalStock.get();
            if (stock.getQuantity() > 0) {
                stock.decrementQuantity(1);
                stockRepository.save(stock);
                exisitingProduct.get().setStatus('D');
                productRepository.save(exisitingProduct.get());
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean updateStock(String id, int quantity, String request) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            if (request == "Increment") {
                product.getStock().incrementQuantity(quantity);
                productRepository.save(product);
                return true;
            } else if (request == "Decrement" && product.getStock().getQuantity() > 0 && product.getStock().getQuantity() >= quantity) {
                product.getStock().decrementQuantity(quantity);
                productRepository.save(product);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean reduceProduct(Map<String, Integer> productItem) {

        for (String productId : productItem.keySet()) {
            if (!productStock.checkProduct(productId, productItem.get(productId))) {
                return false;
            }
        }
        for (String productId : productItem.keySet()) {
            productStock.changeProduct(productId, productItem.get(productId));
        }
        return true;

    }


}
