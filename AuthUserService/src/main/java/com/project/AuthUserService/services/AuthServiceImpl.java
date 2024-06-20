package com.project.AuthUserService.services;


import com.project.AuthUserService.dtos.requestDtos.LoginRequestDto;
import com.project.AuthUserService.dtos.requestDtos.LogoutRequestDto;
import com.project.AuthUserService.dtos.requestDtos.SignUpRequestDto;
import com.project.AuthUserService.dtos.requestDtos.ValidationRequestDto;
import com.project.AuthUserService.dtos.responseDtos.AuthResponseDto;
import com.project.AuthUserService.dtos.responseDtos.LoginResponseDto;
import com.project.AuthUserService.dtos.responseDtos.RoleResponseDto;
import com.project.AuthUserService.exceptions.UnauthorizedRequestException;
import com.project.AuthUserService.exceptions.UserAlreadyExistException;
import com.project.AuthUserService.exceptions.UserNotFoundException;
import com.project.AuthUserService.models.Role;
import com.project.AuthUserService.models.Session;
import com.project.AuthUserService.models.SessionStatus;
import com.project.AuthUserService.models.User;
import com.project.AuthUserService.repositories.RoleRepository;
import com.project.AuthUserService.repositories.SessionRepository;
import com.project.AuthUserService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMapAdapter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public AuthResponseDto signup(SignUpRequestDto request) throws UserAlreadyExistException {
        AuthResponseDto response = new AuthResponseDto();
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        if(userOptional.isPresent()){
            throw new UserAlreadyExistException("User Already Exist");
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Role role = new Role();
        role.setRole("USER");
        roleRepository.save(role);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        User savedUser = userRepository.save(user);

        response.setEmail(savedUser.getEmail());
        response.setName(savedUser.getName());
        RoleResponseDto rolesResponse = new RoleResponseDto();
        rolesResponse.setRole(savedUser.getRoles().get(0).getRole());
        List<RoleResponseDto> roleResponses = new ArrayList<>();
        roleResponses.add(rolesResponse);
        response.setRoles(roleResponses);
        return response;
    }



    @Override
    public ResponseEntity<LoginResponseDto> login(LoginRequestDto request) throws UserNotFoundException, UnauthorizedRequestException {
        LoginResponseDto response = new LoginResponseDto();
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(()-> new UserNotFoundException("User does not present"));
        if (!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new UnauthorizedRequestException("this is an unauthorized request, Please check your password");
        }

        String token = jwtService.generateToken(user);
        MultiValueMapAdapter<String,String> headers = new MultiValueMapAdapter<>(new HashMap<>());
        headers.add("AUTH_TOKEN", token);

        Session session = new Session();
        session.setSessionStatus(SessionStatus.ACTIVE);
        session.setToken(token);
        session.setUser(user);
        session.setExpiringAt(jwtService.extractExpiration(token).toInstant());
        sessionRepository.save(session);

        response.setUserId(user.getId());
        response.setUserName(user.getName());
        return new ResponseEntity<>(response,headers, HttpStatus.OK);

    }

    @Override
    public SessionStatus validateToken(ValidationRequestDto request) {
        Optional<Session> sessionOptional = sessionRepository.findByToken(request.getToken());
        if (sessionOptional.isEmpty()){
            return SessionStatus.INVALID;
        }

        if (!sessionOptional.get().getSessionStatus().equals(SessionStatus.ACTIVE)){
            return SessionStatus.EXPIRED;
        }

        Instant currentTime = Instant.now();
        Instant sessionExpiryTime  = sessionOptional.get().getExpiringAt();
        if (sessionExpiryTime.isBefore(currentTime)){
            return SessionStatus.EXPIRED;
        }

        return SessionStatus.ACTIVE;
    }

    @Override
    public void logout(LogoutRequestDto request) {
        Optional<Session> sessionOptional = sessionRepository.findByToken(request.getToken());
        Session session = sessionOptional.get();
        session.setSessionStatus(SessionStatus.LOGGED_OUT);
        sessionRepository.save(session);
    }


}

