package com.gamepil.task.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequestDto(
        @NotBlank(message = "Email must not be empty")
        String email,

        @NotBlank(message = "Password must not be empty")
        String password
) {
}
