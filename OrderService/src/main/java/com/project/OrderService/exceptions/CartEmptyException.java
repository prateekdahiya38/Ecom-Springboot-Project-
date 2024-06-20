package com.project.OrderService.exceptions;

public class CartEmptyException extends Exception{
    public CartEmptyException(String message) {
        super(message);
    }
}
