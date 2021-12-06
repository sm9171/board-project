package com.example.boardproject.application.user;

import com.example.boardproject.domain.user.User;
import com.example.boardproject.domain.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.example.boardproject.application.user.UserModel.fromUserAndToken;

@RestController
public class UserRestController {

    private final UserService userService;

    UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public UserModel postUser(@Valid @RequestBody UserPostRequestDTO dto) {
        User userSaved = userService.signUp(dto.toSignUpRequest());
        return fromUserAndToken(userSaved, "");
    }

}
