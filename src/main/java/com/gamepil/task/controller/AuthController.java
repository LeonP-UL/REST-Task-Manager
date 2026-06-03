package com.gamepil.task.controller;

import com.gamepil.task.dto.AuthResponse;
import com.gamepil.task.dto.RegisterRequestDto;
import com.gamepil.task.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<AuthResponse> registerUser(
            @Valid @RequestBody RegisterRequestDto registerRequestDto
            ) {
        return ResponseEntity.ok(authService.register(registerRequestDto));
    }
}
