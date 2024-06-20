package com.project.ProductService.dtos.productservicedtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AddProductInCartRequestDto {
    private UUID userId;
    private UUID productId;
    private int quantity;
}