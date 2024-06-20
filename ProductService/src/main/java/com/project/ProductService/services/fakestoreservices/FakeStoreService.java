package com.project.ProductService.services.fakestoreservices;

import com.project.ProductService.dtos.fakestoredtos.AddProductRequestDto;
import com.project.ProductService.dtos.fakestoredtos.ProductResponseDto;
import com.project.ProductService.models.Product;

import java.util.List;

public interface FakeStoreService {
    public List<ProductResponseDto> getAllProducts();
    public ProductResponseDto getProduct(int productId);
    public ProductResponseDto addNewProduct(AddProductRequestDto requestDto);
    public Product updateProduct(Product product, Long productId);
    public boolean isProductDeleted(Long productId);
}

