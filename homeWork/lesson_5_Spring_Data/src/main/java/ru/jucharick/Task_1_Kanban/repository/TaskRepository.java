package ru.jucharick.Task_1_Kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.jucharick.Task_1_Kanban.domain.Task;
import ru.jucharick.Task_1_Kanban.domain.TaskStatus;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> getTasksByStatus(TaskStatus status);
}