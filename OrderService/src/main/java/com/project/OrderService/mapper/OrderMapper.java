package com.project.OrderService.mapper;

import com.project.OrderService.dtos.CartItemDto;
import com.project.OrderService.dtos.OrderItemDto;
import com.project.OrderService.models.OrderItem;
import lombok.Getter;


public class OrderMapper {

    public static OrderItemDto orderItemToOrderItemDtoConvertor(OrderItem orderItem){
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setProductName(orderItem.getProductName());
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItemDto.setPrice(orderItem.getPrice());
        return orderItemDto;
    }

    public static OrderItem cartItemDtoToOrderItem(CartItemDto cartItemDto){
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(cartItemDto.getProductId());
        orderItem.setProductName(cartItemDto.getProductName());
        orderItem.setQuantity(cartItemDto.getQuantity());
        orderItem.setPrice(cartItemDto.getPrice());
        return orderItem;
    }
}
