package com.project.OrderService.exceptions.controlleradvice;

import com.project.OrderService.exceptions.CartEmptyException;
import com.project.OrderService.exceptions.OrderNotFoundException;
import com.project.OrderService.exceptions.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class OrderControllerAdvice {
    @ExceptionHandler(CartEmptyException.class)
    public ResponseEntity<ExceptionResponseDto> cartEmptyException(CartEmptyException e){
        ExceptionResponseDto responseDto = new ExceptionResponseDto();
        responseDto.setResponseStatus(ResponseStatus.FAILURE);
        responseDto.setMessage(e.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> orderNotFoundException(OrderNotFoundException e){
        ExceptionResponseDto responseDto = new ExceptionResponseDto();
        responseDto.setResponseStatus(ResponseStatus.FAILURE);
        responseDto.setMessage(e.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }
}
