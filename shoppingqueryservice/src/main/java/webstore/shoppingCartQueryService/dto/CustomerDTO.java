package webstore.shoppingCartQueryService.dto;

public class CustomerDTO {
    String customerNumber;
    String firstName;
    String lastName;

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
}
