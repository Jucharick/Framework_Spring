package ru.jucharick.Tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    //region Поля
    /**
     * Идентификатор
     */
    private int id;

    /**
     * Имя
     */
    private String firstName ;

    /**
     * Фамилия
     */
    private String lastName ;

    /**
     * Должность
     */
    private String position;

    /**
     * Команда
     */
    private String team;

    /**
     * email
     */
    private String email;
    //endregion
}

