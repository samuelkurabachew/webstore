package webshop.client;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import webshop.client.domain.Address;
import webshop.client.domain.ContactInformation;
import webshop.client.domain.Customer;
import webshop.client.domain.Product;

import java.util.Arrays;

@Component
public class ShoppingCartQueryComponent implements ApplicationRunner {

    @Autowired
    private RestOperations restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Customer> request = new HttpEntity<>(requestHeaders);
        Gson gson = new Gson();
        String shoppingServerUrl = "http://localhost:9090/api/v1/shoppingcartsquery/";

//        System.out.println("********************** ShoppingCart Query Request **********************");
//        System.out.println();




        //		********************** Retrieve Product from Shopping Cart **********************

//        ResponseEntity<String> shoppingCartListResult = restTemplate.exchange(
//                shoppingServerUrl+"f9ada869-f59b-4694-acf6-a5895f8f4c74",
//                HttpMethod.GET, request, String.class);
//
//        System.out.println(shoppingCartListResult.getBody());
//        System.out.println();






        //		********************** Checkout from Shopping Cart and also adding Customer **********************


//        Address address1 = new Address(
//                "1100 S 7th Street", "Iowa City", "563333"
//        );
//
//        ContactInformation contactInformation1 = new ContactInformation(
//                "234-455-1323",
//                "yade.emiru@gmail.com"
//        );
//        Customer addedCustomer1 = new Customer(
//                "Abel", "Mesfin", address1, contactInformation1
//        );
//
//        HttpEntity<Customer> request2 = new HttpEntity<>(addedCustomer1,requestHeaders);
//        ResponseEntity<String> productResult2 = restTemplate.exchange(
//                shoppingServerUrl+"/c038ede0-957a-47b2-a2fc-b26fbae28913/checkout",
//                HttpMethod.POST, request2, String.class);
//
//        System.out.println(productResult2.getBody());
//
//        System.out.println("********************** Product Added to Shopping Cart **********************");
    }
}
