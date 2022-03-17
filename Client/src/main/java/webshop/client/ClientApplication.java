package webshop.client;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import webshop.client.domain.*;
import webshop.client.util.ObjectMapperUtil;

import java.util.Arrays;



@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Customer> request = new HttpEntity<>(requestHeaders);
		Gson gson = new Gson();

		String customerServerUrl = "http://localhost:9090/api/v1/customers/";








//		System.out.println("********************** Customer Request **********************");
//		System.out.println();
//
//		System.out.println("********************** Customer Get By ID **********************");
//
//
//		ResponseEntity<String> st = restTemplate.exchange(
//				customerServerUrl+"62320b43a4b36a0971fb650b",
//				HttpMethod.GET, request, String.class);
//
//
//		if(st != null){
//			Customer dto = gson.fromJson(st.getBody(), Customer.class);
//			System.out.println(dto.toString());
//		}
//		System.out.println();
//
//
//		Address address1 = new Address(
//				"1100 S 7th Street", "Iowa City", "563333"
//		);
//
//		ContactInformation contactInformation1 = new ContactInformation(
//				"234-455-1323",
//				"yade.emiru@gmail.com"
//		);
//		Customer addedCustomer1 = new Customer(
//				"Abel", "Mesfin", address1, contactInformation1
//		);
//
//
//		HttpEntity<?> request2 = new HttpEntity<>(addedCustomer1,requestHeaders);
//		ResponseEntity<String> customer = restTemplate.exchange(
//				customerServerUrl,
//				HttpMethod.POST, request2, String.class);
//
//		Customer customerCreatedResultReturn = gson.fromJson(customer.getBody(), Customer.class);
//		System.out.println("********************** Customer Created **********************");
//
//		System.out.println(customerCreatedResultReturn.toString());

	}

	@Bean
	RestOperations restTemplate() {
		return new RestTemplate();
	}
}
