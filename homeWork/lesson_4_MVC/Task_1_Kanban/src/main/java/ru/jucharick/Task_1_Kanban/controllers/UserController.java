package ru.jucharick.Task_1_Kanban.controllers;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

import ru.jucharick.Task_1_Kanban.domain.Task;
import ru.jucharick.Task_1_Kanban.domain.User;
import ru.jucharick.Task_1_Kanban.services.TaskService;
import ru.jucharick.Task_1_Kanban.services.UserService;

@Controller
public class UserController {
    //region Поля
    /**
     * UserService
     */
    private final UserService userService;
    private final TaskService taskService;
    //endregion

    //region Конструкторы
    @Autowired
    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }
    //endregion

    //region Методы
    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping ("/user/{id}")
    public String findUser(@PathVariable("id") Integer id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        List<Task> tasks = taskService.findTaskByUserId(id);
        model.addAttribute("tasks", tasks);
        return "user";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping ("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Integer id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/users";
    }
    //endregion
}
