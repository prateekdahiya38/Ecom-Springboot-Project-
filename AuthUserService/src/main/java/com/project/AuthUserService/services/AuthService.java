package com.project.AuthUserService.services;

import com.project.AuthUserService.dtos.requestDtos.LoginRequestDto;
import com.project.AuthUserService.dtos.requestDtos.LogoutRequestDto;
import com.project.AuthUserService.dtos.requestDtos.SignUpRequestDto;
import com.project.AuthUserService.dtos.requestDtos.ValidationRequestDto;
import com.project.AuthUserService.dtos.responseDtos.AuthResponseDto;
import com.project.AuthUserService.dtos.responseDtos.LoginResponseDto;
import com.project.AuthUserService.exceptions.UnauthorizedRequestException;
import com.project.AuthUserService.exceptions.UserAlreadyExistException;
import com.project.AuthUserService.exceptions.UserNotFoundException;
import com.project.AuthUserService.models.SessionStatus;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    AuthResponseDto signup(SignUpRequestDto request) throws UserAlreadyExistException;
    ResponseEntity<LoginResponseDto> login(LoginRequestDto request) throws UserNotFoundException, UnauthorizedRequestException;
    SessionStatus validateToken(ValidationRequestDto request);
    void logout(LogoutRequestDto request);
}
