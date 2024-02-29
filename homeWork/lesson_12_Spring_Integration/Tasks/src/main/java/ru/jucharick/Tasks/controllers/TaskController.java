package ru.jucharick.Tasks.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

import ru.jucharick.Tasks.domain.Task;
import ru.jucharick.Tasks.services.FileGateway;
import ru.jucharick.Tasks.services.TaskService;

@Controller
@RequiredArgsConstructor
public class TaskController {
    //region Поля
    /**
     * TaskService
     */
    private final TaskService taskService;
    private final FileGateway fileGateway;
    //endregion

    //region Методы
    @GetMapping("/tasks")
    public String findAllTask(Model model){
        //fileGateway.writeLog("log.txt", LocalDateTime.now() + "  вызван метод findAllTask()");
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
        fileGateway.writeToFile(task.getTitle() + ".txt", task.toString());
        fileGateway.writeLog("log.txt", LocalDateTime.now() + "  вызван метод createTask() " + "создана таска " + task.getTitle());
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping ("/task-delete/{id}")
    public String deleteTask(@PathVariable("id") Integer id){
        fileGateway.writeLog("log.txt", LocalDateTime.now() + "  вызван метод deleteTask() " + "удалена таска id " + id);
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
        fileGateway.writeLog("log.txt", LocalDateTime.now() + "  вызван метод updateTask() " + "изменена таска id " + task.getId() + " " + task.getTitle());
        taskService.updateTask(task);
        return "redirect:/tasks";
    }
    //endregion
}
