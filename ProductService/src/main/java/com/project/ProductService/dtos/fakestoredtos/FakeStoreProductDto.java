package com.project.ProductService.dtos.fakestoredtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private int id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
    private FakeStoreProductRatingDto rating;
}
