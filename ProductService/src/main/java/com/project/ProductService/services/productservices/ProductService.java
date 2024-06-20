package com.project.ProductService.services.productservices;

import com.project.ProductService.dtos.productservicedtos.DBAddProductRequestDto;
import com.project.ProductService.dtos.productservicedtos.DBProductResponseDto;
import com.project.ProductService.exceptions.CategoryNotFoundException;
import com.project.ProductService.models.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public List<DBProductResponseDto> getAllProducts();
    public DBProductResponseDto getProduct(UUID productId);
    public DBProductResponseDto addNewProduct(DBAddProductRequestDto requestDto) throws CategoryNotFoundException;
    public List<DBProductResponseDto> getAllProductsByCategory(UUID categoryId);
    public Product updateProduct(Product product, UUID productId);
    public boolean isProductDeleted(UUID productId);
}

