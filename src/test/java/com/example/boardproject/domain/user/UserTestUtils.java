package com.example.boardproject.domain.user;

import org.springframework.test.util.ReflectionTestUtils;

public class UserTestUtils {

    public static User userWithEmailAndName(String email, String name) {
        return User.of(
                email,name,
                null
        );
    }


}
