package com.project.ProductService.dtos.productservicedtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DBAddProductRequestDto {
    private String title;
    private double price;
    private String desc;
    private String imageUrl;
    private UUID category;
    private int quantity;
}
