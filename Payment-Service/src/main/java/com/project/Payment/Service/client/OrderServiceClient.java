package com.project.Payment.Service.client;

import com.project.Payment.Service.dtos.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class OrderServiceClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public OrderDto getOrder(UUID orderId){
        String orderClientUrl = "http://localhost:8082/order/" + orderId;
        RestTemplate restTemplate =restTemplateBuilder.build();
        ResponseEntity<OrderDto> orderDtoResponse= restTemplate.getForEntity(orderClientUrl, OrderDto.class);
        return orderDtoResponse.getBody();
    }
}
