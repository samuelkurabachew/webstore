package webshop.client.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import webshop.client.domain.Customer;

public class ObjectMapperUtil {

    public static Customer getCustomerClass(String test){
        ObjectMapper mapper=new ObjectMapper();
       return mapper.convertValue(test,Customer.class);
    }
}
