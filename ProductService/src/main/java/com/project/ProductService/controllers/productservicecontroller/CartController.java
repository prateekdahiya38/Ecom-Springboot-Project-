package com.project.ProductService.controllers.productservicecontroller;

import com.project.ProductService.dtos.productservicedtos.AddProductInCartRequestDto;
import com.project.ProductService.dtos.productservicedtos.AddProductInCartResponseDto;
import com.project.ProductService.dtos.productservicedtos.CartResponseDto;
import com.project.ProductService.exceptions.LowQuantityException;
import com.project.ProductService.exceptions.OutOfStockException;
import com.project.ProductService.services.productservices.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping()
    public ResponseEntity<AddProductInCartResponseDto> addProductInCart(@RequestBody AddProductInCartRequestDto request) throws LowQuantityException, OutOfStockException {
        return ResponseEntity.ok(cartService.addProductInCart(request));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CartResponseDto> getCartByUser(@PathVariable ("userId") UUID userId){
        return ResponseEntity.ok(cartService.getCartByUser(userId));
    }
}