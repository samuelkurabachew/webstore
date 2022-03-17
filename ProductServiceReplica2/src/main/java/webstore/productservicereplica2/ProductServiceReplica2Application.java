package webstore.productservicereplica2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
public class ProductServiceReplica2Application {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceReplica2Application.class, args);
    }

}
