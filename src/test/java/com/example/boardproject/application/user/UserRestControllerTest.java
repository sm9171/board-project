package com.example.boardproject.application.user;

import com.example.boardproject.domain.user.User;
import com.example.boardproject.domain.user.UserService;
import com.example.boardproject.domain.user.UserSignUpRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.boardproject.domain.user.UserTestUtils.userWithEmailAndName;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @Test
    void when_post_user_expect_valid_userModel() throws Exception {
        when(userService.signUp(any(UserSignUpRequest.class))).thenReturn(sampleUser());

        mockMvc.perform(post("/users")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(samplePostDTO())))
                .andExpect(status().isOk());
    }

    private User sampleUser() {
        return userWithEmailAndName("user@email.com", "username");
    }
    private UserPostRequestDTO samplePostDTO() {
        return new UserPostRequestDTO("user@email.com", "username", "password");
    }
}