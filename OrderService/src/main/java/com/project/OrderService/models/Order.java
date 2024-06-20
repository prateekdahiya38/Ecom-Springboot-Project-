package com.project.OrderService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity (name = "ecom_order")
public class Order extends BaseModel{
    private UUID userId;
    @OneToMany
    private List<OrderItem> orderItems;
    private double totalPrice;
}
