package webshop.order.domain;


// Stub Class
public class Product {

    private String productNumber;
    private String description;
    private String price;

    public Product(String productNumber, String description, String price) {
        this.productNumber = productNumber;
        this.description = description;
        this.price = price;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }
}
