package webshop.client;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import webshop.client.domain.Product;
import webshop.client.domain.shoppingModel.ShoppingCart;

import java.util.Arrays;

@Component
public class ShoppingCartCommandComponent {

    @Autowired
    private RestOperations restTemplate;

    //@Override
    public void run(ApplicationArguments args) throws Exception {
//        HttpHeaders requestHeaders = new HttpHeaders();
//        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<Product> request = new HttpEntity<>(requestHeaders);
//        Gson gson = new Gson();
//        String shoppingServerUrl = "http://localhost:8080/api/v1/shoppingcartscommand/";
//
//        System.out.println("********************** ShoppingCart Command Request **********************");
//        System.out.println();
//

        	//	********************** Put Product to Shopping Cart for the first time **********************

//
//        Product product1 = new Product(
//                "6232e0dc63ad3712a130fb45" ,
//                "M1 Mac Pro 133", 1599, "Apple Product Laptops");
//
//        HttpEntity<Product> request1 = new HttpEntity<>(product1,requestHeaders);
//        ResponseEntity<String> productResult1 = restTemplate.exchange(
//                shoppingServerUrl,
//                HttpMethod.POST, request1, String.class);
//
//        ShoppingCart cartResultReturn = gson.fromJson(productResult1.getBody(), ShoppingCart.class);
//        System.out.println(cartResultReturn);
//        System.out.println();
//
//
//        System.out.println("********************** Product Added to Shopping Cart **********************");
//
//
//
//
//        //		********************** Put Product to Shopping Cart **********************
//
//        Product product2 = new Product(
//                "6232ea721b998109af640371" ,
//                "IPhone 13 Pro", 1299, "Mobile Device");
//
//        HttpEntity<Product> request2 = new HttpEntity<>(product2,requestHeaders);
//        ResponseEntity<String> productResult2 = restTemplate.exchange(
//                shoppingServerUrl+"/"+cartResultReturn.getCartNumber()+"/add",
//                HttpMethod.PUT, request2, String.class);
//
//
//        ShoppingCart cartUpdateResultReturn = gson.fromJson(productResult2.getBody(), ShoppingCart.class);
//        System.out.println(cartUpdateResultReturn);
//        System.out.println();
//
//        System.out.println("********************** Product Added to Already Created Shopping Cart **********************");
//
//
//
//
//        //		********************** Put Product to Shopping Cart **********************
//
//
//
//
//
//
//
//
//        //		********************** Delete a Product from Shopping Cart **********************
//
//        Product product3 = new Product(
//                "6232e0dc63ad3712a130fb45" ,
//                "IPhone 13 Pro", 1299, "Mobile Device");
//
//        HttpEntity<Product> request3 = new HttpEntity<>(product3,requestHeaders);
//
//        ResponseEntity<String> productResult4 = restTemplate.exchange(
//                shoppingServerUrl+"/"+cartResultReturn.getCartNumber()+"/remove",
//                HttpMethod.PUT, request3, String.class);
//
//        ShoppingCart cartDeletedResultReturn = gson.fromJson(productResult4.getBody(), ShoppingCart.class);
//        System.out.println(cartDeletedResultReturn);

        System.out.println("********************** Product Removed from Shopping Cart **********************");



    }
}
