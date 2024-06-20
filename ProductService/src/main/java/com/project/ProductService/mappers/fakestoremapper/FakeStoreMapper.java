package com.project.ProductService.mappers.fakestoremapper;

import com.project.ProductService.dtos.fakestoredtos.AddProductRequestDto;
import com.project.ProductService.dtos.fakestoredtos.FakeStoreProductDto;
import com.project.ProductService.dtos.fakestoredtos.NewProductFakeStoreDto;
import com.project.ProductService.dtos.fakestoredtos.ProductResponseDto;

public class FakeStoreMapper {

    public static ProductResponseDto fakestoreProductToProductResponseDto(FakeStoreProductDto fakeStoreProductDto){
        ProductResponseDto response = new ProductResponseDto();
        response.setId(fakeStoreProductDto.getId());
        response.setTitle(fakeStoreProductDto.getTitle());
        response.setPrice(fakeStoreProductDto.getPrice());
        response.setDescription(fakeStoreProductDto.getDescription());
        response.setCategory(fakeStoreProductDto.getCategory());
        response.setImageUrl(fakeStoreProductDto.getImage());
        if (fakeStoreProductDto.getRating() == null) {
            response.setRating(0.0);
        }else{
            response.setRating(fakeStoreProductDto.getRating().getRate());
        }
        return response;
    }


    public static NewProductFakeStoreDto requestProductToNewFakeStoreProductConvertor(AddProductRequestDto requestDto){
        NewProductFakeStoreDto newProductFakeStore = new NewProductFakeStoreDto();
        newProductFakeStore.setTitle(requestDto.getTitle());
        newProductFakeStore.setPrice(requestDto.getPrice());
        newProductFakeStore.setDescription(requestDto.getDesc());
        newProductFakeStore.setCategory(requestDto.getCategory());
        newProductFakeStore.setImage(requestDto.getImageUrl());
        return newProductFakeStore;
    }
}
