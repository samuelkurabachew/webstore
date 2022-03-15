package webshop.order.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Address address;
}
