package ru.juacharick.lesson_2_Spring.Spring.Boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// помещает класс Car в контейнер
// за жизненным циклом, созданием и удалением этого объекта теперь следит фреймворк Spring
// для Spring это просто бины, которые нужно взять в контейнер и создавать/удалять по мере необходимости
public class Car {
    @Autowired
    Engine engine;

//    public Car(Engine engine) {
//        this.engine = engine;
//        engine.go();
//    }

    // Внедрение зависимостей:
    // 1. способ - внедряем через конструктор (основной)
    // 2. способ - через сэттер
    // 3. способ через поле с аннотацией @Autowired
}
