package webshop.order.dto;

import lombok.Getter;
import lombok.Setter;
import webshop.order.entity.Address;

@Getter
@Setter
public class CustomerDTO {

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private Address address;
}
