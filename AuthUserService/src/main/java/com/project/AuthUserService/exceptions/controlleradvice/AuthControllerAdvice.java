package com.project.AuthUserService.exceptions.controlleradvice;


import com.project.AuthUserService.exceptions.UnauthorizedRequestException;
import com.project.AuthUserService.exceptions.UserAlreadyExistException;
import com.project.AuthUserService.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthControllerAdvice {
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionResponseDto> userAlreadyExist(UserAlreadyExistException e){
        ExceptionResponseDto response = new ExceptionResponseDto();
        response.setResponseStatus(ResponseStatus.FAILURE);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> userNotFoundExist(UserNotFoundException e){
        ExceptionResponseDto response = new ExceptionResponseDto();
        response.setResponseStatus(ResponseStatus.FAILURE);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    @ExceptionHandler(UnauthorizedRequestException.class)
    public ResponseEntity<ExceptionResponseDto> unAuthorizedException(UnauthorizedRequestException e){
        ExceptionResponseDto response = new ExceptionResponseDto();
        response.setResponseStatus(ResponseStatus.FAILURE);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response,HttpStatus.UNAUTHORIZED);
    }

}
