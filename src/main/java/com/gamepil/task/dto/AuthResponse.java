package com.gamepil.task.dto;

import java.util.UUID;

public record AuthResponse(
        String token,
        UUID userId,
        String email
) {
}
