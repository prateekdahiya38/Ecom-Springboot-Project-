package com.project.OrderService.controllers;

import com.project.OrderService.dtos.CreateOrderRequestDto;
import com.project.OrderService.dtos.CreateOrderResponseDto;
import com.project.OrderService.dtos.GetOrderResponseDto;
import com.project.OrderService.exceptions.CartEmptyException;
import com.project.OrderService.exceptions.OrderNotFoundException;
import com.project.OrderService.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}")
    public ResponseEntity<CreateOrderResponseDto> createOrder(@PathVariable("userId") UUID userId) throws CartEmptyException {
        return ResponseEntity.ok(orderService.createOrder(userId));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<GetOrderResponseDto> getOrder(@PathVariable("orderId")UUID orderId) throws OrderNotFoundException {
        return ResponseEntity.ok(orderService.getOrder(orderId));
    }
}
