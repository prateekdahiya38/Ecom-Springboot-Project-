package com.project.ProductService.dtos.productservicedtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class DBProductResponseDto implements Serializable {
    private UUID id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageUrl;
    private double rating;
    private int quantity;
}