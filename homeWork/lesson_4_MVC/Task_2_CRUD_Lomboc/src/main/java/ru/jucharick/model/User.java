package ru.jucharick.model;

import lombok.Data;

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
    private String firstName;
    /**
     * Фамилия
     */
    private String lastName;
    //endregion
}