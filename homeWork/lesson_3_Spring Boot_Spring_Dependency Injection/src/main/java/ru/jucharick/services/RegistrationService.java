package ru.jucharick.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jucharick.domain.User;

@Service
public class RegistrationService {
    //region Поля
    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private UserService userService;
    //endregion

    //region Методы
    @Autowired
    private NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * - создается пользователь из параметров метода
     * - созданный пользователь добавляется в репозиторий
     * - через notificationService выводится сообщение в консоль
     */
    public void processRegistration(String name, int age, String email) {
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToDB(newUser);
        notificationService.sendNotification("Add new user to DB");
    }
    //endregion
}