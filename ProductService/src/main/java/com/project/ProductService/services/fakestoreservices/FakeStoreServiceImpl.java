package com.project.ProductService.services.fakestoreservices;


import com.project.ProductService.clients.fakestoreclient.FakeStoreClient;
import com.project.ProductService.dtos.fakestoredtos.AddProductRequestDto;
import com.project.ProductService.dtos.fakestoredtos.FakeStoreProductDto;
import com.project.ProductService.dtos.fakestoredtos.NewProductFakeStoreDto;
import com.project.ProductService.dtos.fakestoredtos.ProductResponseDto;
import com.project.ProductService.exceptions.NoProductFoundException;
import com.project.ProductService.mappers.fakestoremapper.FakeStoreMapper;
import com.project.ProductService.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreServiceImpl")
public class FakeStoreServiceImpl implements FakeStoreService{
    @Autowired
    private FakeStoreClient fakeStoreClient;


    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProducts = fakeStoreClient.getAllProducts();
        List<ProductResponseDto> productDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProducts) {
            productDtos.add(FakeStoreMapper.fakestoreProductToProductResponseDto(fakeStoreProductDto));
        }
        return productDtos;
    }


    @Override
    public ProductResponseDto getProduct(int productId) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.getProduct(productId);
        if(fakeStoreProductDto == null){
            throw new NoProductFoundException("Product of id " + productId + " does not exist");
        }
        ProductResponseDto productDto = FakeStoreMapper.fakestoreProductToProductResponseDto(fakeStoreProductDto);
        return productDto;
    }


    @Override
    public ProductResponseDto addNewProduct(AddProductRequestDto requestDto) {
        NewProductFakeStoreDto newProductFakeStoreDto = FakeStoreMapper.requestProductToNewFakeStoreProductConvertor(requestDto);
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.addNewProduct(newProductFakeStoreDto);
        ProductResponseDto productDto = FakeStoreMapper.fakestoreProductToProductResponseDto(fakeStoreProductDto);
        return productDto;
    }


    @Override
    public Product updateProduct(Product product, Long productId) {
        return null;
    }

    @Override
    public boolean isProductDeleted(Long productId) {
        return false;
    }
}

