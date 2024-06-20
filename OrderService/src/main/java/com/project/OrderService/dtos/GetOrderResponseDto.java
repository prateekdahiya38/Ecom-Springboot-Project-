package com.project.OrderService.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetOrderResponseDto {
    private List<OrderItemDto> orderItems;
    private double totalPrice;
}
