package com.example.customerservice.customers.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

    @Id
    private String customerNumber;
    private String firstName;
    private String lastName;
    private Address address;
    private ContactInformation contactInformation;


    public Customer(){

    }

    public Customer(String firstName, String lastName, Address address, ContactInformation contactInformation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactInformation = contactInformation;
    }

    public Customer(String id, String firstName, String lastName, Address address, ContactInformation contactInformation) {
        this.customerNumber = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactInformation = contactInformation;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
}
