package ru.juacharick.lesson_2_Spring.Spring.Boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		// Car car = new Car(new Engine()); не создаем экземпляры классов самостоятельно
		// Spring сам при помощи аннотаций видит классы, кладет их в контейнер и следит за
		// жизненным циклом, созданием и удалением этих объектов
	}
}

// Внедрение зависимостей:
// 1. способ - внедряем через конструктор (основной)
// 2. способ - через сэттер
// 3. способ через поле с аннотацией @Autowired