package webstore.shoppingCartCommandService.domain;

public class Product {
    String productNumber;
    String name;
    double price;


    public Product(){

    }

    public Product(String productNumber, String productName, double price) {
        this.productNumber = productNumber;
        this.name = productName;
        this.price = price;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
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


}
