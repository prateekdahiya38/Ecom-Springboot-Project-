package com.project.OrderService.services;

import com.project.OrderService.clients.productserviceclient.ProductServiceClient;
import com.project.OrderService.dtos.*;
import com.project.OrderService.exceptions.CartEmptyException;
import com.project.OrderService.exceptions.OrderNotFoundException;
import com.project.OrderService.mapper.OrderMapper;
import com.project.OrderService.models.Order;
import com.project.OrderService.models.OrderItem;
import com.project.OrderService.repositories.OrderItemRepository;
import com.project.OrderService.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private ProductServiceClient productServiceClient;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public CreateOrderResponseDto createOrder(UUID userId) throws CartEmptyException {
        CartDto cartDto = productServiceClient.getCart(userId);
        if (cartDto.getCartItems().isEmpty()){
            throw new CartEmptyException("Cart is empty");
        }

        Order order = new Order();
        order.setUserId(userId);
        double totalAmount = 0.0;
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItemDto cartItemDto : cartDto.getCartItems()){
            OrderItem orderItem = OrderMapper.cartItemDtoToOrderItem(cartItemDto);
            orderItemRepository.save(orderItem);
            totalAmount += orderItem.getPrice();
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        order.setTotalPrice(totalAmount);
        Order savedOrder = orderRepository.save(order);

        CreateOrderResponseDto response = new CreateOrderResponseDto();
        response.setOrderId(savedOrder.getId());
        return response;
    }



    @Override
    public GetOrderResponseDto getOrder(UUID orderId) throws OrderNotFoundException {
        GetOrderResponseDto response = new GetOrderResponseDto();
        Order order = orderRepository.findById(orderId).orElseThrow(
                ()-> new OrderNotFoundException("Order Doesn't Found"));

        List<OrderItemDto> orderItems = new ArrayList<>();
        for (OrderItem orderItem : order.getOrderItems()){
            OrderItemDto orderItemDto = OrderMapper.orderItemToOrderItemDtoConvertor(orderItem);
            orderItems.add(orderItemDto);
        }
        response.setOrderItems(orderItems);
        response.setTotalPrice(order.getTotalPrice());
        return response;
    }
}
