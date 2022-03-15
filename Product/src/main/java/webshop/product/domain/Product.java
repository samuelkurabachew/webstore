package webshop.product.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

    @Id
    private String productNumber;
    private String Name;
    private double Price;
    private String Description;
    private Stock stock;


    public Product(String productNumber, String name, double price, String description) {
        this.productNumber = productNumber;
        Name = name;
        Price = price;
        Description = description;
    }

    public Product() {
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNumber='" + productNumber + '\'' +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", Description='" + Description + '\'' +
                ", stock=" + stock +
                '}';
    }
}
