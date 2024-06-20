package com.project.OrderService.exceptions.controlleradvice;

import com.project.OrderService.exceptions.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponseDto {
    private ResponseStatus responseStatus;
    private String message;
}
