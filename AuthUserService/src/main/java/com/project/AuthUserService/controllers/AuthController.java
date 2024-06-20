package com.project.AuthUserService.controllers;

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
import com.project.AuthUserService.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDto> signUp(@RequestBody SignUpRequestDto request) throws UserAlreadyExistException {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) throws UserNotFoundException, UnauthorizedRequestException {
        return authService.login(request);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto request){
        authService.logout(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/validate")
    public ResponseEntity<SessionStatus> validate(@RequestBody ValidationRequestDto request){
        return ResponseEntity.ok(authService.validateToken(request));
    }
}
