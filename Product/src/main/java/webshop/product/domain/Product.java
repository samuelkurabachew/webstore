package webshop.product.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

    @Id
    private String productNumber;
    private String Name;
    private String Price;
    private String Description;
    private int StockAmount;


    public Product(String productNumber, String name, String price, String description) {
        this.productNumber = productNumber;
        Name = name;
        Price = price;
        Description = description;
    }

    public Product() {
    }
}
