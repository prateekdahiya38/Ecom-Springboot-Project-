package com.project.OrderService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
    private String productName;
    private int quantity;
    private double price;
}
