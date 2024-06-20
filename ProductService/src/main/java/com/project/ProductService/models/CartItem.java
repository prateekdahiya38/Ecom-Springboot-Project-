package com.project.ProductService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CartItem extends BaseModel{
    @ManyToOne
    private Product product;
    private int quantity;
    private double price;
}