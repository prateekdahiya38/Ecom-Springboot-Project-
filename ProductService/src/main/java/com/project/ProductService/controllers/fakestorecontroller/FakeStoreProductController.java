package com.project.ProductService.controllers.fakestorecontroller;

import com.project.ProductService.dtos.fakestoredtos.AddProductRequestDto;
import com.project.ProductService.dtos.fakestoredtos.ProductResponseDto;
import com.project.ProductService.models.Product;
import com.project.ProductService.services.fakestoreservices.FakeStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fakestoreproducts")
public class FakeStoreProductController {

    @Autowired
    private FakeStoreService fakeStoreService;


    @GetMapping()
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        List<ProductResponseDto> productResponseDtos = fakeStoreService.getAllProducts();
        return ResponseEntity.ok(productResponseDtos);
    }


    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable("productId") int productId){
        ProductResponseDto productResponseDto = fakeStoreService.getProduct(productId);
        return ResponseEntity.ok(productResponseDto);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> addNewProduct(@RequestBody AddProductRequestDto requestDto){
        ProductResponseDto productResponseDto = fakeStoreService.addNewProduct(requestDto);
        return ResponseEntity.ok(productResponseDto);
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
