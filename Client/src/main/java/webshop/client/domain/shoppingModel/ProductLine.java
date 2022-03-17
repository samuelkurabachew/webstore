package webshop.client.domain.shoppingModel;



public class ProductLine {
    private Product product;
    private int quantity;


    public ProductLine(){

    }

    public ProductLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductLine{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
