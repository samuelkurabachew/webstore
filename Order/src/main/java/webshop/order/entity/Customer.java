package webshop.order.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private String firstName;
    private String lastName;
    private ContactInformation contactInformation;
    private Address address;
}
