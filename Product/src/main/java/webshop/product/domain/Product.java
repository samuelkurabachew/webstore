package webshop.product.domain;

public class Product {

    private String productNumber;
    private String Name;
    private double Price;
    private String Description;


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
}
