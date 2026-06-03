package com.gamepil.task.service;

import com.gamepil.task.dto.AuthResponse;
import com.gamepil.task.dto.RegisterRequestDto;
import com.gamepil.task.entity.User;
import com.gamepil.task.exception.EmailAlreadyExistsException;
import com.gamepil.task.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse register(RegisterRequestDto request) {

        if (userRepository.existsByEmail(request.email())){
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = new User();
        user.setUserName(request.name());
        user.setEmail(request.email());

        String hashedPassword = passwordEncoder.encode(request.password());
        user.setPassword(hashedPassword);

        userRepository.save(user);

        return new AuthResponse("User " + user.getUserName() + " registered successfully", user.getEmail());
    }
}
