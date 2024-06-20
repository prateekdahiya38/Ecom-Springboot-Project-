package com.project.OrderService.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class OrderItem extends BaseModel{
    private UUID productId;
    private String productName;
    private int quantity;
    private double price;
}
