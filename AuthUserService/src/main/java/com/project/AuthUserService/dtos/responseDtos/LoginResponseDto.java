package com.project.AuthUserService.dtos.responseDtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class LoginResponseDto {
    private UUID userId;
    private String userName;
}
