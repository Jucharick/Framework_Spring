package ru.juacharick.lesson_2_Spring.Spring.Boot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Qualifier
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

//	В Spring Framework существует множество аннотаций, которые используются для
//	определения и конфигурации бинов. Вот несколько основных из них:
//		1. @Component: Это общая аннотация, которую можно использовать для
//		определения любого бина. Классы, аннотированные как @Component,
//		автоматически сканируются Spring и регистрируются в контейнере IoC.
//		2. @Service: Это специализированная версия @Component, предназначенная
//		для классов, которые представляют бизнес-логику приложения. Она не
//		добавляет дополнительной функциональности по сравнению с @Component,
//		но помогает лучше структурировать код.
//		3. @Repository: Это еще одна специализированная версия @Component,
//		предназначенная для классов, которые взаимодействуют с системой
//		хранения данных. Она может интегрироваться с механизмом перехвата
//		исключений Spring Data Access, который автоматически преобразует
//		исключения хранилища данных в исключения Spring DataAccessException.
//		4. @Controller: Это специализированная версия @Component, предназначенная
//		для классов, которые обрабатывают HTTP-запросы в веб-приложениях Spring
//		MVC или Spring WebFlux.
//		5. @Configuration: Эта аннотация используется для классов, которые
//		определяют бины с помощью методов @Bean. Эти классы играют роль
//		источников определения бинов для контейнера IoC.
//		6. @Bean: Эта аннотация используется вместе с @Configuration для определения
//		бинов. Методы, аннотированные как @Bean, создают объекты, которые
//		управляются Spring и добавляются в контейнер IoC.
