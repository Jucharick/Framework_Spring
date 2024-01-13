package ru.juacharick.lesson_2_Spring.Spring.Boot;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(("prod"))
public class ProdEngine implements Engine{
    public ProdEngine() {
        System.out.println("Двигатель запущен на сервере!");
    }

    @Override
    public void go() {
        System.out.println("Поехали быстро!");
    }
}
