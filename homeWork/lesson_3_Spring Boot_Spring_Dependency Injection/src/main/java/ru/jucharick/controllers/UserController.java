package ru.jucharick.controllers;

import ru.jucharick.domain.User;
import ru.jucharick.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {
    //region Поля
    @Autowired
    private RegistrationService service;
    //endregion

    //region Методы
    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromParam(@RequestBody User user) {
        service.processRegistration(user.getName(), user.getAge(), user.getEmail());
        return "User added from body!";
    }
    //endregion
}
