package webshop.customer.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Address {
    private String street;
    private String city;
    private String zip;

}
