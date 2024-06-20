package com.project.ProductService.mappers.productservicemapper;

import com.project.ProductService.dtos.productservicedtos.DBAddProductRequestDto;
import com.project.ProductService.dtos.productservicedtos.DBProductResponseDto;
import com.project.ProductService.models.Product;

public class DBProductMapper {

    public static Product dbProductRequestDtoToProduct(DBAddProductRequestDto requestDto){
        Product product = new Product();
        product.setTitle(requestDto.getTitle());
        product.setDescription(requestDto.getDesc());
        product.setPrice(requestDto.getPrice());
        product.setImageUrl(requestDto.getImageUrl());
        product.setRating(0.0);
        product.setQuantity(requestDto.getQuantity());
        return product;
    }

    public static DBProductResponseDto productToDBProductResponseDto(Product product) {
        DBProductResponseDto responseDto = new DBProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        responseDto.setDescription(product.getDescription());
        responseDto.setCategory(product.getCategory().getName());
        responseDto.setImageUrl(product.getImageUrl());
        responseDto.setRating(0.0);
        responseDto.setQuantity(product.getQuantity());
        return responseDto;
    }
}
