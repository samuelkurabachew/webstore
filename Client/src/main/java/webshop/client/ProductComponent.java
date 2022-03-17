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
import webshop.client.domain.ProductResponse;

import java.util.Arrays;

@Component
public class ProductComponent {

    @Autowired
    private RestOperations restTemplate;

   // @Override
    public void run(ApplicationArguments args) throws Exception {
//        HttpHeaders requestHeaders = new HttpHeaders();
//        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<Customer> request = new HttpEntity<>(requestHeaders);
//        Gson gson = new Gson();
//        String productServerUrl = "http://localhost:8080/api/v1/product/";
//
//
//        System.out.println("********************** Product Request **********************");
//        System.out.println();
//
////		********************** Create Product **********************
//
//		Product product1 = new Product("IPhone 12 Pro", 1099, "Apple Product Mobile");
//		HttpEntity<Product> request1 = new HttpEntity<>(product1,requestHeaders);
//		ResponseEntity<String> productResult1 = restTemplate.exchange(
//				productServerUrl,
//				HttpMethod.POST, request1, String.class);
//
//        ProductResponse productCreatedResultReturn = gson.fromJson(productResult1.getBody(), ProductResponse.class);
//		System.out.println("********************** Product Created **********************");


//		System.out.println(productCreatedResultReturn.getData().toString());
//		System.out.println();
//
//
//
//
//
//
//
////		********************** Update Product **********************
//
//		System.out.println("********************** Update Product **********************");
//
//		Product product2 = new Product(productCreatedResultReturn.getData().getProductNumber(),"M1 Mac Air 133", 1599, "Apple Product Laptops");
//
//		HttpEntity<?> request2 = new HttpEntity<>(product2,requestHeaders);
//		ResponseEntity<String> productResult2 = restTemplate.exchange(
//				productServerUrl+"/"+productCreatedResultReturn.getData().getProductNumber(),
//				HttpMethod.PUT, request2, String.class);
//
//		ProductResponse productUpdatedResultReturn = gson.fromJson(productResult2.getBody(), ProductResponse.class);
//		System.out.println(productUpdatedResultReturn.getData().toString());
//		System.out.println();
//
//
//
//
//
//
//
////		********************** Get Product **********************
//
//		System.out.println("********************** Get Product with ID **********************");
//
//		ResponseEntity<String> productResult3 = restTemplate.exchange(
//				productServerUrl+productCreatedResultReturn.getData().getProductNumber(),
//				HttpMethod.GET, request, String.class);
//
//
//		ProductResponse productResultReturn = gson.fromJson(productResult3.getBody(), ProductResponse.class);
//		System.out.println(productResultReturn.getData().toString());
//
//
////		********************** End Product **********************
    }
}
