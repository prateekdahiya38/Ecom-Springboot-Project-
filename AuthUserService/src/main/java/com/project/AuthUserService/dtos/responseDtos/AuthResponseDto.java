package com.project.AuthUserService.dtos.responseDtos;

import com.project.AuthUserService.models.Role;
import com.project.AuthUserService.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AuthResponseDto {
    private String name;
    private String email;
    private List<RoleResponseDto> roles;


    public static AuthResponseDto userToUserResponseDtoMapper(User user){
        if (user == null){
            return null;
        }
        AuthResponseDto response = new AuthResponseDto();
        response.name = user.getName();
        response.email = user.getEmail();
        response.roles = new ArrayList<>();
        for (Role role : user.getRoles()){
            RoleResponseDto responseDto = new RoleResponseDto();
            responseDto.setRole(role.getRole());
            responseDto.setDesc(role.getDesc());
            response.roles.add(responseDto);
        }
        return response;
    }


    public static User userResponseDtoToUserMapper(AuthResponseDto response){
        return null;
    }
}
