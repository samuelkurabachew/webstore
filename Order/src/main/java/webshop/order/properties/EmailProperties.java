package webshop.order.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "mail")
public class EmailProperties {

    private String host;

    private String username;

    private String password;

    private int port;

    private String protocol;
}