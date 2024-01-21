package ru.jucharick.domain;

public class User {
    //region Поля
    /**
     * Идентификатор
     */
    private int id;
    /**
     * Имя
     */
    private String name;
    /**
     * Возраст
     */
    private int age;
    /**
     * email
     */
    private String email;
    //endregion

    //region Методы
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //endregion
}
