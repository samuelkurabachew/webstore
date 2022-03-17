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

	}

	@Bean
	RestOperations restTemplate() {
		return new RestTemplate();
	}
}
