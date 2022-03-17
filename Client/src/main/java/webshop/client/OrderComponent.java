package webshop.client;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import webshop.client.domain.Customer;
import webshop.client.domain.OrderConfirm;
import webshop.client.domain.Product;

import java.util.Arrays;

@Component
public class OrderComponent implements ApplicationRunner {

    @Autowired
    private RestOperations restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> request = new HttpEntity<>(requestHeaders);
        Gson gson = new Gson();
        String orderServerUrl = "http://localhost:9090/api/v1/order/";


        System.out.println("********************** Order Request **********************");
        System.out.println();




        //		********************** Retrieve Product from Order List **********************

//        ResponseEntity<String> shoppingCartListResult = restTemplate.exchange(
//                orderServerUrl+"71",
//                HttpMethod.GET, request, String.class);
//
//        System.out.println(shoppingCartListResult.getBody());
//        System.out.println();






        //		********************** Confirm Checkout (Place order) **********************


//        OrderConfirm orderConfirm = new OrderConfirm(
//                "71","62327d3eec1afd56603e249b");
//
//        HttpEntity<OrderConfirm> request2 = new HttpEntity<>(orderConfirm,requestHeaders);
//        ResponseEntity<String> orderResult = restTemplate.exchange(
//                orderServerUrl+"/confirm",
//                HttpMethod.POST, request2, String.class);
//
//        System.out.println(orderResult.getBody());
//
//        System.out.println("********************** Order has been sent **********************");

    }
}
