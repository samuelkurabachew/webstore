package webshop.client.domain.order;

import lombok.Getter;
import lombok.Setter;
import webshop.client.domain.Address;
import webshop.client.domain.ContactInformation;

@Getter
@Setter
public class Customer {

    private String firstName;
    private String lastName;
    private ContactInformation contactInformation;
    private Address address;
}
