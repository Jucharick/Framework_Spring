package domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class GasolinEngin implements iEngin {
    public GasolinEngin() {
        System.out.println("Создан экземпляр GasolinEngin");
    }

    @Override
    public void startEngine() {
        System.out.println("Запущен Бензин 44р.л");
    }
}
