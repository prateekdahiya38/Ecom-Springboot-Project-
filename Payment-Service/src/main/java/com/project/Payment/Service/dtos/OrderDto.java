package com.project.Payment.Service.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {
private List<OrderItemDto> orderItems;
private double totalPrice;
}
