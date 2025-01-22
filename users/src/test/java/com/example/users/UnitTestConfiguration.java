package com.example.users;

import com.example.users.service.UserService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class UnitTestConfiguration {

    @Bean
    public UserService userService() {
        return Mockito.mock(UserService.class);
    }
}