package com.project.OrderService.services;

import com.project.OrderService.dtos.CreateOrderRequestDto;
import com.project.OrderService.dtos.CreateOrderResponseDto;
import com.project.OrderService.dtos.GetOrderResponseDto;
import com.project.OrderService.exceptions.CartEmptyException;
import com.project.OrderService.exceptions.OrderNotFoundException;

import java.util.UUID;

public interface OrderService {
    CreateOrderResponseDto createOrder(UUID userId) throws CartEmptyException;
    GetOrderResponseDto getOrder(UUID orderId) throws OrderNotFoundException;
}
