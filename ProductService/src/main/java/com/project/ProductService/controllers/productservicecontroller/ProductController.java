package com.project.ProductService.controllers.productservicecontroller;

import com.project.ProductService.dtos.productservicedtos.DBAddProductRequestDto;
import com.project.ProductService.dtos.productservicedtos.DBProductResponseDto;
import com.project.ProductService.exceptions.CategoryNotFoundException;
import com.project.ProductService.models.Product;
import com.project.ProductService.services.productservices.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    //    @Cacheable(value = "products")
    @GetMapping()
    public ResponseEntity<List<DBProductResponseDto>> getAllProducts(){
        List<DBProductResponseDto> dbProductResponseDtos = productService.getAllProducts();
        return ResponseEntity.ok(dbProductResponseDtos);
    }


    //    @Cacheable(value = "products", key = "#productId")
    @GetMapping("/{productId}")
    public ResponseEntity<DBProductResponseDto> getProduct(@PathVariable("productId") UUID productId){
        DBProductResponseDto dbProductResponseDto = productService.getProduct(productId);
        return ResponseEntity.ok(dbProductResponseDto);
    }

    @PostMapping()
    public ResponseEntity<DBProductResponseDto> addNewProduct(@RequestBody DBAddProductRequestDto requestDto) throws CategoryNotFoundException {
        DBProductResponseDto dbProductResponseDto = productService.addNewProduct(requestDto);
        return ResponseEntity.ok(dbProductResponseDto);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<DBProductResponseDto>> getAllProductsByCategory(@PathVariable("categoryId") UUID categoryId){
        List<DBProductResponseDto> dbProductResponseDtos = productService.getAllProductsByCategory(categoryId);
        return ResponseEntity.ok(dbProductResponseDtos);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(Product product, @PathVariable("productId") int productId){
        return null;
    }

    @DeleteMapping("/{productId}")
    public boolean isProductDeleted(@PathVariable("productId") int productId){
        return true;
    }
}

