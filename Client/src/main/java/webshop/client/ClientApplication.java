package webshop.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String serverUrl = "http://10.10.16.43:8080/books";



	}

	@Bean
	RestOperations restTemplate() {
		return new RestTemplate();
	}
}
