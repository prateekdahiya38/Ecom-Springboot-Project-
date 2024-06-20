package com.project.ProductService.dtos.productservicedtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductInCategoryDto {
    private UUID id;
    private String title;
    private double price;
    private double rating;
}
