package com.project.ProductService.controllers.productservicecontroller;

import com.project.ProductService.dtos.productservicedtos.CategoryRequestDto;
import com.project.ProductService.dtos.productservicedtos.CategoryResponseDto;
import com.project.ProductService.exceptions.CategoryNotFoundException;
import com.project.ProductService.services.productservices.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;




    @PostMapping()
    public ResponseEntity<CategoryResponseDto> addCategory(@RequestBody CategoryRequestDto request){
        CategoryResponseDto response = categoryService.addCategory(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<List<CategoryResponseDto>> getAllCategory(){
        List<CategoryResponseDto> response = categoryService.getAllCategory();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable("categoryId") UUID categoryId) throws CategoryNotFoundException {
        CategoryResponseDto response = categoryService.getCategory(categoryId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable("categoryId")UUID categoryId){
        CategoryResponseDto response = categoryService.updateCategory(categoryId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<CategoryResponseDto> deleteCategory(@PathVariable("categoryId") UUID categoryId){
        CategoryResponseDto response = categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/totalprice/{categoryId}")
    public ResponseEntity<Double> getTotalPriceForAllProducts(@PathVariable("categoryId") UUID categoryId) throws CategoryNotFoundException {
        return ResponseEntity.ok(categoryService.getTotalPriceForAllProducts(categoryId));
    }

}
