package com.gamepil.task.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record CreateTaskRequestDto(
        @NotBlank(message ="Title cannot be empty")
        String title,

        String description,

        LocalDate dueDate
) {

}
