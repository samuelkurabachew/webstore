package webshop.product.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Stock {
    @Id
    private String stockId;
    private Product product;
    private int quantity;


    public Stock() {
        quantity = 1;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String id){
        stockId = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity(int count) {
        this.quantity = quantity + count;
    }

    public void decrementQuantity(int count) {
        this.quantity = quantity - count;
    }
}
