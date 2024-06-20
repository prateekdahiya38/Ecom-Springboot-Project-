package com.project.ProductService.exceptions.controlleradvice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponseDto {
    private ResponseStatus responseStatus;
    private String message;
}
