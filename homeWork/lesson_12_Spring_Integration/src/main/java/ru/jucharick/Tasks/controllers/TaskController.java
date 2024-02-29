package ru.jucharick.Tasks.controllers;


import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

import ru.jucharick.Tasks.domain.Task;
import ru.jucharick.Tasks.services.TaskService;

@Controller
public class TaskController {
    //region Поля
    /**
     * TaskService
     */
    private final TaskService taskService;
    //endregion

    //region Конструкторы
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
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
    public String createUser(Task task){
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping ("/task-delete/{id}")
    public String deleteTask(@PathVariable("id") Integer id){
        taskService.deleteById(id);
        return "redirect:/tasks";
    }

    @GetMapping("/task-update/{id}")
    public String updateTaskForm(@PathVariable("id") Integer id, Model model){
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "task-update";
    }

    @PostMapping("/task-update")
    public String updateTask(@ModelAttribute("task") Task task){
        taskService.updateTask(task);
        return "redirect:/tasks";
    }
    //endregion
}
