package com.gamepil.task.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequestDto(
        @NotBlank(message = "Name must not be empty")
        @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters")
        String name,

        @NotBlank(message = "Email must not be empty")
        @Email(message = "Email must be valid")
        String email,

        @NotBlank(message = "Password must not be empty")
        @Size(min = 6, message = "Password must be at least 6 characters")
        String password
) {
}
