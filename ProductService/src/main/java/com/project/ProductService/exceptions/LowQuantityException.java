package com.project.ProductService.exceptions;

public class LowQuantityException extends Exception{
    public LowQuantityException(String message) {
        super(message);
    }
}
