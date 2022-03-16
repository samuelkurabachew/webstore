package webshop.order.dto;

import lombok.Getter;
import lombok.Setter;
import webshop.order.entity.Address;
import webshop.order.entity.ContactInformation;

import java.io.Serializable;

@Getter
@Setter
public class CustomerDTO implements Serializable {

    private String firstName;

    private String lastName;

    private ContactInformation contactInformation;

    private Address address;
}
