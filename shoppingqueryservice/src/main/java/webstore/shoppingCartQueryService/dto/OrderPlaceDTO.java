package webstore.shoppingCartQueryService.dto;

public class OrderPlaceDTO {
    CustomerDTO customerDTO;
    ShoppingCartDTO shoppingCartDTO;

    public OrderPlaceDTO(){

    }

    public OrderPlaceDTO(CustomerDTO customerDTO, ShoppingCartDTO shoppingCartDTO) {
        this.customerDTO = customerDTO;
        this.shoppingCartDTO = shoppingCartDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public ShoppingCartDTO getShoppingCartDTO() {
        return shoppingCartDTO;
    }
}
