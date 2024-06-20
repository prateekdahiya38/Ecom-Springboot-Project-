package com.project.OrderService.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CartDto {
    private UUID cartId;
    private List<CartItemDto> cartItems;
}
