package webshop.order.dto;

import lombok.Getter;
import lombok.Setter;
import webshop.order.entity.Address;
import webshop.order.entity.ContactInformation;

@Getter
@Setter
public class CustomerDTO {

    private String customerNumber;

    private String firstName;

    private String lastName;

    private ContactInformation contactInformation;

    private Address address;
}
