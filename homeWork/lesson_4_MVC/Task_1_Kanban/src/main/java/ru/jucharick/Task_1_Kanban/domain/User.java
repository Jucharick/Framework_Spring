package ru.jucharick.Task_1_Kanban.domain;

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

    //region Методы
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //endregion
}

