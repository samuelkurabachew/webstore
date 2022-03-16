package webstore.shoppingqueryservice.domain;

public class ShoppingCartAdopter {
    public static ShoppingCartDTO convert(ShoppingCart cart){
        ShoppingCartDTO cartDTO = new ShoppingCartDTO();
        cartDTO.setCartNumber(cart.getCartNumber());
        cartDTO.setProductLineList(cart.getProductLineList());
        return cartDTO;
    }
}
