package com.project.AuthUserService.exceptions.controlleradvice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponseDto {
    private ResponseStatus responseStatus;
    private String message;
}
