package webshop.client;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import webshop.client.domain.Customer;
import webshop.client.domain.Product;

import java.util.Arrays;
import java.util.Map;

@Component
public class ShoppingCartCommandComponent implements ApplicationRunner {

    @Autowired
    private RestOperations restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> request = new HttpEntity<>(requestHeaders);
        Gson gson = new Gson();
        String shoppingServerUrl = "http://localhost:9090/api/v1/shoppingcartscommand/";

        System.out.println("********************** ShoppingCart Command Request **********************");
        System.out.println();

        //		********************** Put Product to Shopping Cart for the first time **********************


//        Product product1 = new Product(
//                "6232944a3f63447414c95f17" ,
//                "M1 Mac Pro 133", 1599, "Apple Product Laptops");
//
//        HttpEntity<Product> request1 = new HttpEntity<>(product1,requestHeaders);
//        ResponseEntity<String> productResult1 = restTemplate.exchange(
//                shoppingServerUrl,
//                HttpMethod.POST, request1, String.class);
//
//        System.out.println(productResult1.getBody());
//
//        System.out.println("********************** Product Added to Shopping Cart **********************");



        //		********************** Put Product to Shopping Cart **********************

//        Product product2 = new Product(
//                "623211eed95e951ad053a69c" ,
//                "IPhone 13 Pro", 1299, "Mobile Device");
//
//        HttpEntity<Product> request2 = new HttpEntity<>(product2,requestHeaders);
//        ResponseEntity<String> productResult2 = restTemplate.exchange(
//                shoppingServerUrl+"/f9ada869-f59b-4694-acf6-a5895f8f4c74/add",
//                HttpMethod.PUT, request2, String.class);
//
//        System.out.println(productResult2.getBody());
//
//        System.out.println("********************** Product Added to Already Created Shopping Cart **********************");


        //		********************** Delete a Product from Shopping Cart **********************

//        Product product3 = new Product(
//                "623211eed95e951ad053a69c" ,
//                "IPhone 13 Pro", 1299, "Mobile Device");
//
//        HttpEntity<Product> request3 = new HttpEntity<>(product3,requestHeaders);
//
//        ResponseEntity<String> productResult3 = restTemplate.exchange(
//                shoppingServerUrl+"/f9ada869-f59b-4694-acf6-a5895f8f4c74/remove",
//                HttpMethod.PUT, request3, String.class);
//
//        System.out.println(productResult3.getBody());
//
//        System.out.println("********************** Product Removed from Shopping Cart **********************");



    }
}
