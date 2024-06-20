package com.project.ProductService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Cart extends BaseModel{
    private UUID userId;
    @OneToMany
    private List<CartItem> cartItems;
    private double totalPrice;

}

