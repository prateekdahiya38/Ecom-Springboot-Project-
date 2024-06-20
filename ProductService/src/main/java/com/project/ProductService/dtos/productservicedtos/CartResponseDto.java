package com.project.ProductService.dtos.productservicedtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CartResponseDto {
    private UUID cartId;
    private List<CartItemDto> cartItems;

}
