package com.example.users.dto;

import com.example.users.entity.User;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String email;

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
