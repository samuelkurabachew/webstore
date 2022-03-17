package webshop.client.domain.shoppingModel;


public class Product {


    private String productNumber;

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    private String name;
    private double price;


    public Product(String productNumber, String name, double price) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public Product() {
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }



    @Override
    public String toString() {
        return "Product{" +
                "productNumber='" + productNumber + '\'' +
                ", productName='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
