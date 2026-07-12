package com.gamepil.task.repository;

import com.gamepil.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository  extends JpaRepository<Task, UUID> {

    List<Task> findAllByOwnerId(UUID ownerId);
}
