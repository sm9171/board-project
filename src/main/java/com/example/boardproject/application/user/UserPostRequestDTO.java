package com.example.boardproject.application.user;

import com.example.boardproject.domain.user.UserSignUpRequest;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Value;

import javax.validation.constraints.NotBlank;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.WRAPPER_OBJECT;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeName("user")
@JsonTypeInfo(include = WRAPPER_OBJECT, use = NAME)
@Value
public class UserPostRequestDTO {

    @javax.validation.constraints.Email
    String email;
    @NotBlank
    String name;
    @NotBlank
    String password;

    UserSignUpRequest toSignUpRequest() {
        return new UserSignUpRequest(email,name, password);
    }
}
