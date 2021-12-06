package com.example.boardproject.domain.user;

public class UserSignUpRequest {
    private final String email;
    private final String name;
    private final String password;

    public UserSignUpRequest(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
