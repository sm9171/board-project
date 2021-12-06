package com.example.boardproject.domain.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User signUp(UserSignUpRequest request) {
        return userRepository.save(User.of(request.getEmail(),
                request.getUserName(),
                request.getPassword()));
    }

    @Transactional(readOnly = true)
    public Optional<User> login(String email, String password) {
        return userRepository.findFirstByEmail(email);
    }
}
