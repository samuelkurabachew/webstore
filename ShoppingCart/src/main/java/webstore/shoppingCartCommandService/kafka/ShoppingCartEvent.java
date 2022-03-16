package webstore.shoppingCartCommandService.kafka;

import webstore.shoppingCartCommandService.domain.Product;


public class ShoppingCartEvent{
    String event;
    Product product;
    String cartNumber;

    public ShoppingCartEvent(){

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
