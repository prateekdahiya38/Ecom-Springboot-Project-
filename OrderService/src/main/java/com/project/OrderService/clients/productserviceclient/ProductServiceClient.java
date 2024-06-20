package com.project.OrderService.clients.productserviceclient;

import com.project.OrderService.dtos.CartDto;
import com.project.OrderService.dtos.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class ProductServiceClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public ProductDto getProduct(UUID productId){
        String productClientUrl = "http://localhost:8080/products/" + productId;
        RestTemplate restTemplate =restTemplateBuilder.build();
        ResponseEntity<ProductDto> productDto = restTemplate.getForEntity(productClientUrl,ProductDto.class);
        return productDto.getBody();
    }

    public CartDto getCart(UUID userId){
        String cartClientUrl = "http://localhost:8080/cart/" + userId;
        RestTemplate restTemplate =restTemplateBuilder.build();
        ResponseEntity<CartDto> cartDto = restTemplate.getForEntity(cartClientUrl,CartDto.class);
        return cartDto.getBody();
    }
}
