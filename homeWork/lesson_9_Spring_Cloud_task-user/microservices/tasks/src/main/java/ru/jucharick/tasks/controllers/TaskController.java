package ru.jucharick.tasks.controllers;



import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import ru.jucharick.tasks.domain.Task;
import ru.jucharick.tasks.services.TaskService;

@Controller
@AllArgsConstructor
public class TaskController {
    //region Поля
    /**
     * TaskService
     */
    private final TaskService taskService;
    //endregion

    //region Методы
    @GetMapping("/tasks")
    public String findAllTask(Model model){
        List<Task> tasks = taskService.findAllTask();
        model.addAttribute("tasks", tasks);
        return "tasks-list";
    }

    @GetMapping("/task-create")
    public String creatTaskForm(Task task){
        return "task-create";
    }

    @PostMapping("/task-create")
    public String createTask(Task task){
        taskService.createTask(task);
        return "redirect:/tasks";
    }

    @GetMapping ("/task-delete/{id}")
    public String deleteTask(@PathVariable("id") Long id){
        taskService.deleteById(id);
        return "redirect:/tasks";
    }

    @GetMapping("/task-update/{id}")
    public String updateTaskForm(@PathVariable("id") Long id, Model model){
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "task-update";
    }

    @PostMapping("/task-update")
    public String updateTask(@PathVariable("id") Long id, @ModelAttribute("task") Task task){
        taskService.updateTask(id, task);
        return "redirect:/tasks";
    }
    //endregion
}

