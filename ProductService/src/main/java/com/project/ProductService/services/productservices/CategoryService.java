package com.project.ProductService.services.productservices;


import com.project.ProductService.dtos.productservicedtos.CategoryRequestDto;
import com.project.ProductService.dtos.productservicedtos.CategoryResponseDto;
import com.project.ProductService.exceptions.CategoryNotFoundException;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    public CategoryResponseDto addCategory(CategoryRequestDto request);
    public List<CategoryResponseDto> getAllCategory();
    public CategoryResponseDto getCategory(UUID categoryId) throws CategoryNotFoundException;
    public CategoryResponseDto updateCategory(UUID categoryId);
    public CategoryResponseDto deleteCategory(UUID categoryId);
    public double getTotalPriceForAllProducts(UUID categoryId) throws CategoryNotFoundException;

}
