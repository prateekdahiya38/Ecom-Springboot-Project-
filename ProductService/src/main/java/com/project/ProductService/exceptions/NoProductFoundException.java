package com.project.ProductService.exceptions;

public class NoProductFoundException extends RuntimeException{
    public NoProductFoundException(String message) {
        super(message);
    }
}
