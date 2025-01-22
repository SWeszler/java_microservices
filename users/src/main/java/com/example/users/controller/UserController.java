package com.example.users.controller;

import com.example.users.dto.UserDto;
import com.example.users.dto.UserRequestDto;
import com.example.users.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> users() {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getUsers());
    }

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserRequestDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createUser(userDto));
    }
}
