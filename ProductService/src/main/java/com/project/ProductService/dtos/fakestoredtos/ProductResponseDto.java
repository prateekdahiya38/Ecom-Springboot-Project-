package com.project.ProductService.dtos.fakestoredtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageUrl;
    private double rating;
}