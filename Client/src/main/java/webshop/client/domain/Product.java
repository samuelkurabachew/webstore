package webshop.client.domain;

public class Product {

    private String productNumber;

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    private String productName;
    private double price;
    private String description;
    private Stock stock;


    public Product(String productNumber, String name, double price, String description, Stock stock) {
        this.productNumber = productNumber;
        this.productName = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public Product(String name, double price, String description) {
        this.productName = name;
        this.price = price;
        this.description = description;
    }

    public Product(String productNumber ,String name, double price, String description) {
        this.productNumber = productNumber;
        this.productName = name;
        this.price = price;
        this.description = description;
    }


    public Product() {
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getProductName() {
        return productName;
    }


    public double getPrice() {
        return price;
    }


    public String getDescription() {
        return description;
    }


    public Stock getStock() {
        return stock;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productNumber='" + productNumber + '\'' +
                ", ProductName='" + productName + '\'' +
                ", Price=" + price +
                ", Description='" + description + '\'' +
                ", stock=" + stock +
                '}';
    }
}
