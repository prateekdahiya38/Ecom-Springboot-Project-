package com.project.ProductService.dtos.fakestoredtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewProductFakeStoreDto {
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
