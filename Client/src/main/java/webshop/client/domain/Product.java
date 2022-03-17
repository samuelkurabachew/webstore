package webshop.client.domain;

public class Product {

    private String productNumber;

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    private String name;
    private double price;
    private String description;
    private Stock stock;


    public Product(String productNumber, String name, double price, String description, Stock stock) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product() {
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", Name='" + name + '\'' +
                ", Price=" + price +
                ", Description='" + description + '\'' +
                ", stock=" + stock +
                '}';
    }
}
