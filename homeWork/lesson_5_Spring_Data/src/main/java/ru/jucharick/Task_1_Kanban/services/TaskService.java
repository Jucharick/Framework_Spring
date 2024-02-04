package ru.jucharick.Task_1_Kanban.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import ru.jucharick.Task_1_Kanban.domain.Task;
import ru.jucharick.Task_1_Kanban.domain.TaskStatus;
import ru.jucharick.Task_1_Kanban.repository.TaskRepository;

@Service
@AllArgsConstructor
public class TaskService {
    //region Поля
    /**
     * UserRepository
     */
    private final TaskRepository taskRepository;
    //endregion

    //region Методы
    public List<Task> findAllTask(){
        return taskRepository.findAll();
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.getTasksByStatus(status);
    }

    public Task createTask(Task task){
        task.setDateTime(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

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
    //endregion
}
