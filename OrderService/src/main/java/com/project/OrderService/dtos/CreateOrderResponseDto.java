package com.project.OrderService.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateOrderResponseDto {
    private UUID orderId;
}
