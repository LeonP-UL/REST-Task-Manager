package com.gamepil.task.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponseDto(
        String message,
        LocalDateTime timestamp,
        List<FieldErrorDto> fieldErrors
) {
}
