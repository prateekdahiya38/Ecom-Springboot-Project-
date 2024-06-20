package com.project.ProductService.mappers.productservicemapper;

import com.project.ProductService.dtos.productservicedtos.CategoryResponseDto;
import com.project.ProductService.dtos.productservicedtos.ProductInCategoryDto;
import com.project.ProductService.models.Category;
import com.project.ProductService.models.Product;

public class DBCategoryMapper {

    public static CategoryResponseDto categoryToCategoryResponseDto(Category category){
        CategoryResponseDto response = new CategoryResponseDto();;
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }

    public static ProductInCategoryDto productToProductinCategory(Product product){
        ProductInCategoryDto productInCategoryDto = new ProductInCategoryDto();
        productInCategoryDto.setId(product.getId());
        productInCategoryDto.setTitle(productInCategoryDto.getTitle());
        productInCategoryDto.setPrice(productInCategoryDto.getPrice());
        productInCategoryDto.setRating(productInCategoryDto.getRating());
        return productInCategoryDto;
    }
}