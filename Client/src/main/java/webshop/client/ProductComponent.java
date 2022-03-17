package webshop.client;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import webshop.client.domain.Customer;

import java.util.Arrays;

@Component
public class ProductComponent implements ApplicationRunner {

    @Autowired
    private RestOperations restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Customer> request = new HttpEntity<>(requestHeaders);
        Gson gson = new Gson();
        String productServerUrl = "http://localhost:9090/api/v1/product/";


        System.out.println("********************** Product Request **********************");
        System.out.println();

//		********************** Create Product **********************

//		Product product1 = new Product("Mac Pro 13", 1499, "Apple Product Laptop");
//
//		HttpEntity<Product> request1 = new HttpEntity<>(product1,requestHeaders);
//		ResponseEntity<String> productResult1 = restTemplate.exchange(
//				productServerUrl,
//				HttpMethod.POST, request1, String.class);
//
////		Product productCreatedResultReturn = gson.fromJson(productResult1.getBody(), Product.class);
//		System.out.println("********************** Product Created **********************");
//
//		System.out.println(productResult1.getBody());
////		System.out.println(productCreatedResultReturn.toString());
//		System.out.println();

//		********************** Update Product **********************

//		System.out.println("********************** Update Product **********************");
//
//		Product product2 = new Product("62328a3d9551d3145f48a367","M1 Mac Pro 133", 1599, "Apple Product Laptops");
//
//		HttpEntity<?> request2 = new HttpEntity<>(product2,requestHeaders);
//		ResponseEntity<String> productResult2 = restTemplate.exchange(
//				productServerUrl+"/6232944a3f63447414c95f17",
//				HttpMethod.PUT, request2, String.class);
//
//		System.out.println(productResult2.getBody());
//		Product productUpdatedResultReturn = gson.fromJson(productResult2.getBody(), Product.class);
//		System.out.println(productUpdatedResultReturn.toString());

//		********************** Get Product **********************

//		System.out.println("********************** Get Product **********************");
//
		ResponseEntity<String> productResult3 = restTemplate.exchange(
				productServerUrl+"6232944a3f63447414c95f17",
				HttpMethod.GET, request, String.class);

		System.out.println(productResult3.getBody());
		System.out.println();

//		********************** End Product **********************
    }
}
