package com.project.ProductService.dtos.productservicedtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CartItemDto {
    private UUID productId;
    private String productName;
    private int quantity;
    private double price;
}