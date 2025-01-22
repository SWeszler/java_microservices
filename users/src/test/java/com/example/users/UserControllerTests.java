package com.example.users;

import com.example.users.dto.UserDto;
import com.example.users.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(UnitTestConfiguration.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testUsers() throws Exception {
        UserDto user1 = new UserDto();
        user1.setUsername("user1");
        user1.setEmail("user1@example.com");

        UserDto user2 = new UserDto();
        user2.setUsername("user2");
        user2.setEmail("user2@example.com");

        given(userService.getUsers()).willReturn(Arrays.asList(user1, user2));

        String result = mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'username':'user1','email':'user1@example.com'},{'username':'user2','email':'user2@example.com'}]"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(result);
    }
}