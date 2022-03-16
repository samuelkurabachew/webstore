package webshop.order.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Address implements Serializable {

    private String city;
    private String state;
    private String zipCode;
}
