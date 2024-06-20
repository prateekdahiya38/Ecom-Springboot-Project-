package com.project.OrderService.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductDto {
    private UUID id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageUrl;
    private double rating;
    private int quantity;
}
