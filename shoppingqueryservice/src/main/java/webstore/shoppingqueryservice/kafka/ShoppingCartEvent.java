package webstore.shoppingqueryservice.kafka;

import webstore.shoppingqueryservice.domain.Product;

public class ShoppingCartEvent {
    String event;
    Product product;
    String cartNumber;

    ShoppingCartEvent(){

    }

    public ShoppingCartEvent(String event, Product product, String cartNumber) {
        this.event = event;
        this.product = product;
        this.cartNumber = cartNumber;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }
}
