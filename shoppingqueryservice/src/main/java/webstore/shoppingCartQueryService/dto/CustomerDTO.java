package webstore.shoppingCartQueryService.dto;

import webstore.shoppingCartQueryService.domain.Address;
import webstore.shoppingCartQueryService.domain.ContactInformation;

public class CustomerDTO {
    private String customerNumber;
    private String firstName;
    private String lastName;
    private ContactInformation contactInformation;

    private Address address;

    public CustomerDTO(){

    }

    public CustomerDTO(String customerNumber, String firstName, String lastName) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
