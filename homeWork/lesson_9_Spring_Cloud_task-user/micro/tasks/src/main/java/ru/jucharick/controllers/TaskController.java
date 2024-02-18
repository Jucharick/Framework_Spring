package ru.jucharick.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import ru.jucharick.domain.Task;
import ru.jucharick.domain.TaskStatus;
import ru.jucharick.services.TaskService;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    //region Поля
    /**
     * TaskService
     */
    private final TaskService taskService;
    //endregion

    //region Методы
    @GetMapping
    public List<Task> getAllTasks(){;
        return taskService.findAllTask();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable("status") TaskStatus status){
        return taskService.getTasksByStatus(status);
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @DeleteMapping ("/task-delete/{id}")
    public void deleteTask(@PathVariable("id") Long id){
        taskService.deleteById(id);
    }

    @PutMapping("/task-update/{id}")
    public Task updateTask(@PathVariable("id") Long id,  @RequestBody Task task){
        return taskService.updateTask(id, task);
    }
    //endregion
}
