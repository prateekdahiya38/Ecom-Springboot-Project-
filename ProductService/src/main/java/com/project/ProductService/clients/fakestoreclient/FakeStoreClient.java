package com.project.ProductService.clients.fakestoreclient;

import com.project.ProductService.dtos.fakestoredtos.FakeStoreProductDto;
import com.project.ProductService.dtos.fakestoredtos.NewProductFakeStoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}")
    private String fakeStoreBaseUrl;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreProductPath;


    public List<FakeStoreProductDto> getAllProducts(){
        String gellAllProductUrl = fakeStoreBaseUrl.concat(fakeStoreProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtoList = restTemplate.getForEntity(gellAllProductUrl, FakeStoreProductDto[].class);
        return List.of(fakeStoreProductDtoList.getBody());
    }

    public FakeStoreProductDto getProduct(int productId){
        String getProductUrl = fakeStoreBaseUrl.concat(fakeStoreProductPath + "/" + productId);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDto = restTemplate.getForEntity(getProductUrl, FakeStoreProductDto.class);
        return fakeStoreProductDto.getBody();
    }

    public FakeStoreProductDto addNewProduct(NewProductFakeStoreDto newProductFakeStoreDto){
        String addNewProductUrl = fakeStoreBaseUrl.concat(fakeStoreProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDto = restTemplate.postForEntity(addNewProductUrl,newProductFakeStoreDto, FakeStoreProductDto.class);
        return fakeStoreProductDto.getBody();
    }
}
