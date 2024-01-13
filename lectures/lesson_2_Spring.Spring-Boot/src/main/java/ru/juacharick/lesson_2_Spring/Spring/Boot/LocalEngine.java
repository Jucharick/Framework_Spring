package ru.juacharick.lesson_2_Spring.Spring.Boot;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Primary
@Profile(("local"))
// помещает класс Engine в контейнер
// класс Engine теперь является компонентом приложения
// за жизненным циклом, созданием и удалением этого объекта теперь следит фреймворк Spring
public class LocalEngine implements Engine{
    public LocalEngine() {
        System.out.println("Двигатель запущен локально!");
    }

    @Override
    public void go() {
        System.out.println("Поехали медленно!");
    }
}
