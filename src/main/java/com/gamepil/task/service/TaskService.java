package com.gamepil.task.service;

import com.gamepil.task.dto.CreateTaskRequestDto;
import com.gamepil.task.dto.TaskResponseDto;
import com.gamepil.task.entity.Task;
import com.gamepil.task.entity.User;
import com.gamepil.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponseDto createTask(CreateTaskRequestDto request, User user) {
        Task task = new Task(
                request.title(),
                request.description(),
                request.dueDate(),
                user
        );

        Task savedTask = taskRepository.save(task);
        return mapToResponse(savedTask);
    }

    private TaskResponseDto mapToResponse(Task task) {
        return new TaskResponseDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getDueDate(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }
}
