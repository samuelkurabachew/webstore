package webstore.apigatewayreplica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayReplicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayReplicaApplication.class, args);
    }

}
