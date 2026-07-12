package com.gamepil.task.dto;

import com.gamepil.task.entity.enumerator.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record TaskResponseDto(
        UUID id,

        String title,

        String description,

        TaskStatus status,

        LocalDate dueDate,

        LocalDateTime createdAt,

        LocalDateTime updatedAt
) {
}
