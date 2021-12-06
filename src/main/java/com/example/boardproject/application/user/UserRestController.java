package com.example.boardproject.application.user;

import com.example.boardproject.domain.user.User;
import com.example.boardproject.domain.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.example.boardproject.application.user.UserModel.fromUserAndToken;
import static org.springframework.http.ResponseEntity.of;

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

    @PostMapping("/users/login")
    public ResponseEntity<UserModel> loginUser(@Valid @RequestBody UserLoginRequestDTO dto) {
        return of(userService.login(dto.getEmail(), dto.getPassword())
                .map(user -> fromUserAndToken(user, "")));
    }

}
