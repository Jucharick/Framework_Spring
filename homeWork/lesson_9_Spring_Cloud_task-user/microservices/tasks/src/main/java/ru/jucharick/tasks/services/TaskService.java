package ru.jucharick.tasks.services;

import ru.jucharick.tasks.domain.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTask();
    Task createTask(Task task);
    void deleteById(Long id);
    Task updateTask(Long id, Task taskToUpdate);
    Task findTaskById (Long id);
}
