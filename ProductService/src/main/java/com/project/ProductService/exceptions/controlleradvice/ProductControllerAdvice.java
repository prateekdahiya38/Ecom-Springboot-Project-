package com.project.ProductService.exceptions.controlleradvice;


import com.project.ProductService.exceptions.CategoryNotFoundException;
import com.project.ProductService.exceptions.LowQuantityException;
import com.project.ProductService.exceptions.NoProductFoundException;
import com.project.ProductService.exceptions.OutOfStockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(NoProductFoundException.class)
    public ResponseEntity<ExceptionResponseDto> NoProductFoundException(NoProductFoundException e){
        ExceptionResponseDto responseDto = new ExceptionResponseDto();
        responseDto.setResponseStatus(ResponseStatus.FAILURE);
        responseDto.setMessage(e.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> invalidCategoryInputException(CategoryNotFoundException e){
        ExceptionResponseDto responseDto = new ExceptionResponseDto();
        responseDto.setResponseStatus(ResponseStatus.FAILURE);
        responseDto.setMessage(e.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LowQuantityException.class)
    public ResponseEntity<ExceptionResponseDto> lowQuantityException(LowQuantityException e){
        ExceptionResponseDto responseDto = new ExceptionResponseDto();
        responseDto.setResponseStatus(ResponseStatus.FAILURE);
        responseDto.setMessage(e.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OutOfStockException.class)
    public ResponseEntity<ExceptionResponseDto> outOfStockException(OutOfStockException e){
        ExceptionResponseDto responseDto = new ExceptionResponseDto();
        responseDto.setResponseStatus(ResponseStatus.FAILURE);
        responseDto.setMessage(e.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }

}

