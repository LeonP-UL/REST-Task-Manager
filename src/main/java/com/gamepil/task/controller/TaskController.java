package com.gamepil.task.controller;

import com.gamepil.task.dto.CreateTaskRequestDto;
import com.gamepil.task.dto.TaskResponseDto;
import com.gamepil.task.entity.CustomUserDetails;
import com.gamepil.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(
            @Valid @RequestBody CreateTaskRequestDto request,
            Authentication authentication
            ) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        TaskResponseDto response = taskService.createTask(request, userDetails.getUser());

        return ResponseEntity.ok(response);
    }
}
