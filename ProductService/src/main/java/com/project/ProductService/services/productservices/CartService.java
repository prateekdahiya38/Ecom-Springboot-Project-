package com.project.ProductService.services.productservices;

import com.project.ProductService.dtos.productservicedtos.AddProductInCartRequestDto;
import com.project.ProductService.dtos.productservicedtos.AddProductInCartResponseDto;
import com.project.ProductService.dtos.productservicedtos.CartResponseDto;
import com.project.ProductService.exceptions.LowQuantityException;
import com.project.ProductService.exceptions.OutOfStockException;

import java.util.UUID;

public interface CartService {
    AddProductInCartResponseDto addProductInCart(AddProductInCartRequestDto request) throws LowQuantityException, OutOfStockException;
    CartResponseDto getCartByUser(UUID userId);
}
