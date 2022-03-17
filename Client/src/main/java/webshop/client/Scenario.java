package webshop.client;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import webshop.client.domain.*;
import webshop.client.domain.order.Order;
import webshop.client.domain.shoppingModel.ShoppingCart;

import java.util.Arrays;

@Component
public class Scenario implements ApplicationRunner {
    @Autowired
    private RestOperations restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Customer> request = new HttpEntity<>(requestHeaders);
        Gson gson = new Gson();
            String productServerUrl = "http://localhost:8080/api/v1/product/";


        System.out.println("********************** Product Request **********************");
        System.out.println();

//		********************** Create Product **********************

        Product product1 = new Product("IPhone 12 Pro", 1099, "Apple Product Mobile");
        Product product2 = new Product("M1 Mac Pro 13", 1599, "Apple Product Laptops");
        HttpEntity<Product> request1 = new HttpEntity<>(product1, requestHeaders);
        HttpEntity<Product> request2 = new HttpEntity<>(product2, requestHeaders);
        ResponseEntity<String> productResult1 = restTemplate.exchange(
                productServerUrl,
                HttpMethod.POST, request1, String.class);

        ResponseEntity<String> productResult2 = restTemplate.exchange(
                productServerUrl,
                HttpMethod.POST, request2, String.class);

        ProductResponse productCreatedResultReturn = gson.fromJson(productResult1.getBody(), ProductResponse.class);
        System.out.println("********************** Product Created **********************");


		System.out.println(productCreatedResultReturn.getData().toString());
		System.out.println();

        ProductResponse otherProductCreatedResultReturn = gson.fromJson(productResult2.getBody(), ProductResponse.class);
        System.out.println("********************** Again Other Product Created **********************");

        System.out.println(otherProductCreatedResultReturn.getData().toString());
        System.out.println();







//		********************** Update Product **********************

		System.out.println("********************** Update Product **********************");

		Product product11 = new Product(otherProductCreatedResultReturn.getData().getProductNumber(),"M1 Mac Air 133", 1599, "Apple Product Laptops");

		HttpEntity<?> request11 = new HttpEntity<>(product11,requestHeaders);
		ResponseEntity<String> productResult11 = restTemplate.exchange(
				productServerUrl+"/"+otherProductCreatedResultReturn.getData().getProductNumber(),
				HttpMethod.PUT, request11, String.class);

		ProductResponse productUpdatedResultReturn = gson.fromJson(productResult11.getBody(), ProductResponse.class);
		System.out.println(productUpdatedResultReturn.getData().toString());
		System.out.println();


        System.out.println("********************** Get Product with ID **********************");

        ResponseEntity<String> productResult3 = restTemplate.exchange(
                productServerUrl+productCreatedResultReturn.getData().getProductNumber(),
                HttpMethod.GET, request, String.class);


        ProductResponse productResultReturn = gson.fromJson(productResult3.getBody(), ProductResponse.class);
        System.out.println(productResultReturn.getData().toString());






        String shoppingServerUrl = "http://localhost:8080/api/v1/shoppingcartscommand/";

        System.out.println("********************** ShoppingCart Command Request **********************");
        System.out.println();


        Product shoppingProduct1 = new Product(
                otherProductCreatedResultReturn.getData().getProductNumber() ,
                "M1 Mac Air 133", 1599, "Apple Product Laptops");

        HttpEntity<Product> shoppingrequest1 = new HttpEntity<>(shoppingProduct1,requestHeaders);
        ResponseEntity<String> shoppingproductResult1 = restTemplate.exchange(
                shoppingServerUrl,
                HttpMethod.POST, shoppingrequest1, String.class);

        ShoppingCart cartResultReturn = gson.fromJson(shoppingproductResult1.getBody(), ShoppingCart.class);
        System.out.println(cartResultReturn);
        System.out.println();


        System.out.println("********************** Product Added to Shopping Cart **********************");




        //		********************** Put Product to Shopping Cart **********************

        Product shoppingproduct2 = new Product(
                productCreatedResultReturn.getData().getProductNumber() ,
                "IPhone 13 Pro", 1299, "Mobile Device");

        HttpEntity<Product> shoppingrequest2 = new HttpEntity<>(shoppingproduct2,requestHeaders);
        ResponseEntity<String> shoppingproductResult2 = restTemplate.exchange(
                shoppingServerUrl+"/"+cartResultReturn.getCartNumber()+"/add",
                HttpMethod.PUT, shoppingrequest2, String.class);


        ShoppingCart cartUpdateResultReturn = gson.fromJson(shoppingproductResult2.getBody(), ShoppingCart.class);
        System.out.println(cartUpdateResultReturn);
        System.out.println();

        System.out.println("********************** Product Added to Already Created Shopping Cart **********************");




        //		********************** Put Product to Shopping Cart **********************








        //		********************** Delete a Product from Shopping Cart **********************

        Product product3 = new Product(
                productCreatedResultReturn.getData().getProductNumber(),
                "IPhone 13 Pro", 1299, "Mobile Device");

        HttpEntity<Product> request3 = new HttpEntity<>(product3,requestHeaders);

        ResponseEntity<String> productResult4 = restTemplate.exchange(
                shoppingServerUrl+"/"+cartResultReturn.getCartNumber()+"/remove",
                HttpMethod.PUT, request3, String.class);

        ShoppingCart cartDeletedResultReturn = gson.fromJson(productResult4.getBody(), ShoppingCart.class);
        System.out.println(cartDeletedResultReturn);

        String shoppingQueryServerUrl = "http://localhost:8080/api/v1/shoppingcartsquery/";

        System.out.println("********************** ShoppingCart Query Request **********************");
        System.out.println();




  //      		********************** Retrieve Product from Shopping Cart **********************

        ResponseEntity<String> shoppingCartListResult = restTemplate.exchange(
                shoppingQueryServerUrl+cartDeletedResultReturn.getCartNumber(),
                HttpMethod.GET, request, String.class);

        System.out.println(shoppingCartListResult.getBody());
        System.out.println();






   //     		********************** Checkout from Shopping Cart and also adding Customer **********************


        Address address1 = new Address(
                "1100 S 7th Street", "Iowa City", "563333"
        );

        ContactInformation contactInformation1 = new ContactInformation(
                "234-455-1323",
                "yOrderade.emiru@gmail.com"
        );
        Customer addedCustomer1 = new Customer(
                "Abel", "Mesfin", address1, contactInformation1
        );


        HttpEntity<Customer> orderrequest2 = new HttpEntity<>(addedCustomer1,requestHeaders);
        ResponseEntity<String> shoppingproductResult4 = restTemplate.exchange(
                shoppingQueryServerUrl+ "" + cartDeletedResultReturn.getCartNumber()+"/checkout",
                HttpMethod.POST, orderrequest2, String.class);

        Order orderResultReturn = gson.fromJson(shoppingproductResult4.getBody(), Order.class);
        System.out.println(orderResultReturn);

        System.out.println("********************** Customer Added to Order **********************");


        String orderServerUrl = "http://localhost:8080/api/v1/order/";


        System.out.println("********************** Order Request **********************");
        System.out.println();




        //    		********************** Retrieve Product from Order List **********************

        ResponseEntity<String> shoppingCartOrderListResult = restTemplate.exchange(
                orderServerUrl+orderResultReturn.getOrderNumber(),
                HttpMethod.GET, request, String.class);

        System.out.println(shoppingCartOrderListResult.getBody());
        System.out.println();






        //    		********************** Confirm Checkout (Place order) **********************


        OrderConfirm orderConfirm = new OrderConfirm(
                orderResultReturn.getOrderNumber(),"62336388af01f3084d229ffc");

        HttpEntity<OrderConfirm> orderConfirmequest2 = new HttpEntity<>(orderConfirm,requestHeaders);
        ResponseEntity<String> orderResult = restTemplate.exchange(
                orderServerUrl+"/confirm",
                HttpMethod.POST, orderConfirmequest2, String.class);

        System.out.println(orderResult.getBody());

        System.out.println("********************** Order has been sent **********************");

    }

}