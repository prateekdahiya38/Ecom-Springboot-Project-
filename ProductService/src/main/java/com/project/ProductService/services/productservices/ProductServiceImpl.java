package com.project.ProductService.services.productservices;


import com.project.ProductService.dtos.productservicedtos.DBAddProductRequestDto;
import com.project.ProductService.dtos.productservicedtos.DBProductResponseDto;
import com.project.ProductService.exceptions.CategoryNotFoundException;
import com.project.ProductService.exceptions.NoProductFoundException;
import com.project.ProductService.mappers.productservicemapper.DBProductMapper;
import com.project.ProductService.models.Category;
import com.project.ProductService.models.Product;
import com.project.ProductService.repositories.CategoryRepository;
import com.project.ProductService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("productServiceImp")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;



    @Override
    public List<DBProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<DBProductResponseDto> dbProductResponseDtos = new ArrayList<>();
        for (Product product : products){
            dbProductResponseDtos.add(DBProductMapper.productToDBProductResponseDto(product));
        }
        return dbProductResponseDtos;
    }


    @Override
    public DBProductResponseDto getProduct(UUID productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new NoProductFoundException("Product Doesn't Found"));
        return DBProductMapper.productToDBProductResponseDto(product);
    }


    @Override
    public DBProductResponseDto addNewProduct(DBAddProductRequestDto requestDto) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(requestDto.getCategory()).orElseThrow(
                ()-> new CategoryNotFoundException("Category Does not exist"));
        Product product = DBProductMapper.dbProductRequestDtoToProduct(requestDto);
        product.setCategory(category);
        Product savedProduct = productRepository.save(product);
        return DBProductMapper.productToDBProductResponseDto(savedProduct);
    }

    @Override
    public List<DBProductResponseDto> getAllProductsByCategory(UUID categoryId) {
        List<Product> products = productRepository.findAllByCategoryId(categoryId);
        if (products == null){
            throw new NoProductFoundException("no product found in this category");
        }
        List<DBProductResponseDto> dbProductResponseDtos = new ArrayList<>();
        for (Product product : products){
            dbProductResponseDtos.add(DBProductMapper.productToDBProductResponseDto(product));
        }
        return dbProductResponseDtos;
    }


    @Override
    public Product updateProduct(Product product, UUID productId) {
        return null;
    }

    @Override
    public boolean isProductDeleted(UUID productId) {
        return false;
    }
}
