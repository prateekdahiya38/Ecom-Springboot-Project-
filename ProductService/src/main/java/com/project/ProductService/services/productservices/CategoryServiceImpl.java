package com.project.ProductService.services.productservices;


import com.project.ProductService.dtos.productservicedtos.CategoryRequestDto;
import com.project.ProductService.dtos.productservicedtos.CategoryResponseDto;
import com.project.ProductService.exceptions.CategoryNotFoundException;
import com.project.ProductService.mappers.productservicemapper.DBCategoryMapper;
import com.project.ProductService.models.Category;
import com.project.ProductService.models.Product;
import com.project.ProductService.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public CategoryResponseDto addCategory(CategoryRequestDto request) {
        Category category = new Category();
        category.setName(request.getName());
        Category savedCategory = categoryRepository.save(category);
        CategoryResponseDto categoryResponseDto = DBCategoryMapper.categoryToCategoryResponseDto(savedCategory);
        return categoryResponseDto;
    }


    @Override
    public List<CategoryResponseDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();
        for (Category category : categories){
            CategoryResponseDto categoryResponseDto = DBCategoryMapper.categoryToCategoryResponseDto(category);
            categoryResponseDtos.add(categoryResponseDto);
        }
        return categoryResponseDtos;
    }



    @Override
    public CategoryResponseDto getCategory(UUID categoryId) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                ()-> new CategoryNotFoundException("No such Category found"));

        return DBCategoryMapper.categoryToCategoryResponseDto(category);
    }

    @Override
    public CategoryResponseDto updateCategory(UUID categoryId) {
        return null;
    }

    @Override
    public CategoryResponseDto deleteCategory(UUID categoryId) {
        return null;
    }

    @Override
    public double getTotalPriceForAllProducts(UUID categoryId) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                ()-> new CategoryNotFoundException("Category not found"));

        if (category.getProducts().isEmpty()){
            return 0.0;
        }else {
            return category.getProducts().stream().map(Product::getPrice).reduce((double) 0, Double :: sum);
        }
    }
}
