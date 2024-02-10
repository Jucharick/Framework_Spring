package ru.jucharick.Spring_Security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/public-data")
    public String user() {
        return "public-data";
    }

    @GetMapping("/private-data")
    public String admin() {
        return "private-data";
    }

    @GetMapping("/login")
    public String auth(){
        return "login";
    }
}
