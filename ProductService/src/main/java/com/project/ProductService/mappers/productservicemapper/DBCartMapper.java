package com.project.ProductService.mappers.productservicemapper;

import com.project.ProductService.dtos.productservicedtos.CartItemDto;
import com.project.ProductService.models.CartItem;

public class DBCartMapper {
    public static CartItemDto cartItemToCartItemDtoConvertor(CartItem cartItem){
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setProductName(cartItem.getProduct().getTitle());
        cartItemDto.setProductId(cartItem.getProduct().getId());
        cartItemDto.setQuantity(cartItem.getQuantity());
        cartItemDto.setPrice(cartItem.getPrice());
        return cartItemDto;
    }
}

