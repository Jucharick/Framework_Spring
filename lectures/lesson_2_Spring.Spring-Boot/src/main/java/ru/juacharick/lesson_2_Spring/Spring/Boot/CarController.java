package ru.juacharick.lesson_2_Spring.Spring.Boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    Car car;

    @GetMapping("/car") // для вызова метода извне http://localhost:8080/car
    public String startCar(){
        car.start();
        return "Автомобиль запущен";
    }
}
