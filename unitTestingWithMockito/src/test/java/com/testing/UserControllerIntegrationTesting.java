package com.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.entity.Users;
import com.repository.UserRepo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepo userRepository;
    @BeforeEach
    void setup() {
        userRepository.deleteAll();
        Users alice = new Users(null, "Alice");
        userRepository.save(alice);
    }
    @Test
    void shouldReturnUserFromDatabase() throws Exception {
        // Find the saved user ID
        Users savedUser = userRepository.findAll().get(0);
        // Perform GET request
        mockMvc.perform(get("/users/" + savedUser.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(savedUser.getId()))
                .andExpect(jsonPath("$.name").value("Alice"));
    }
    @Test
    void shouldReturnNotFoundForMissingUser() throws Exception {
        mockMvc.perform(get("/users/99"))
                .andExpect(status().isNotFound());
    }
}






