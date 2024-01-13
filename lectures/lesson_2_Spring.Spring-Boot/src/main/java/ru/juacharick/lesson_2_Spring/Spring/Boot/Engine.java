package ru.juacharick.lesson_2_Spring.Spring.Boot;

import org.springframework.stereotype.Component;

@Component
// помещает класс Engine в контейнер
// класс Engine теперь является компонентом приложения
// за жизненным циклом, созданием и удалением этого объекта теперь следит фреймворк Spring
public class Engine {
    public Engine() {
        System.out.println("Двигатель запущен!");
    }

    public void go() {
        System.out.println("Поехали!");
    }
}
