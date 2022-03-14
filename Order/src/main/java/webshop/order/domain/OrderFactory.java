package webshop.order.domain;

public class OrderFactory {

    public static Order createOrder(ShoppingCart shoppingCart) {
        Order order = new Order(shoppingCart.getShoppingCartId(), OrderStatus.PLACED);

        for (CartLine cartLine : shoppingCart.getCartLineList()) {
            OrderLine orderLine = new OrderLine();
            //create an order product from a shopping product
            Product product = new Product(cartLine.getProduct().getProductNumber(),
                    cartLine.getProduct().getDescription(),
                    cartLine.getProduct().getPrice());
            orderLine.setProduct(product);
            orderLine.setQuantity(cartLine.getQuantity());
            order.addOrderLine(orderLine);
        }

        return order;
    }
}
