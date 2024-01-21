package ru.jucharick.services;

import ru.jucharick.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
    //region Поля
    @Autowired
    private NotificationService notificationService;
    //endregion

    //region Методы
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);

        return user;
    }
    //endregion
}
