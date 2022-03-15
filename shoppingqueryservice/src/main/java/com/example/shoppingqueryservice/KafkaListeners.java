package com.example.shoppingqueryservice;

import com.example.shoppingqueryservice.service.ShoppingCartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    private final ShoppingCartService shoppingCartService;

    KafkaListeners(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }

    @KafkaListener(
            topics = "shoppigcarttopic",
            groupId = "1"
    )
    void listener(String cartEvent) throws JsonProcessingException {
        ShoppingCartEvent event = new ObjectMapper().readValue(cartEvent, ShoppingCartEvent.class);
        switch (event.event) {
            case "ADD" -> shoppingCartService.addToCart(event.getProduct(), event.getCartNumber());
            case "REMOVE" -> shoppingCartService.removeFromCart(event.getProduct(), event.getCartNumber());
        }
    }
}
