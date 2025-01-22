package com.example.users.service;

import com.example.users.dto.UserDto;
import com.example.users.dto.UserRequestDto;
import com.example.users.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.users.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map(UserDto::from).toList();
    }

    public UserDto createUser(UserRequestDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        this.userRepository.save(user);

        return UserDto.from(user);
    }
}
