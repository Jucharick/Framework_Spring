package ru.jucharick.tasks.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jucharick.tasks.domain.Task;
import ru.jucharick.tasks.repository.TaskRepository;
import ru.jucharick.tasks.services.TaskService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class iTaskService implements TaskService {
    //region Поля
    /**
     * UserRepository
     */
    private final TaskRepository taskRepository;
    //endregion

    //region Методы

    @Override
    public List<Task> findAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(Task task) {
        task.setDateTime(LocalDateTime.now());
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateTask(Long id, Task taskToUpdate) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTitle(taskToUpdate.getTitle());
            task.setDescription(taskToUpdate.getDescription());
            task.setStatus(taskToUpdate.getStatus());
            task.setRequestedBy(taskToUpdate.getRequestedBy());
            task.setAssignedBy(taskToUpdate.getAssignedBy());
            task.setAssigneeID(taskToUpdate.getAssigneeID());
            task.setDateTime(LocalDateTime.now());
            return taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    @Override
    public Task findTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()){
            Task task = optionalTask.get();
            return task;
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }
    //endregion
}
