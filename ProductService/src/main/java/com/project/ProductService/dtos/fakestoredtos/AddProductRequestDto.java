package com.project.ProductService.dtos.fakestoredtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductRequestDto {
    private String title;
    private double price;
    private String desc;
    private String imageUrl;
    private String category;
}