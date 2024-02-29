package ru.jucharick.Tasks.services;

import ru.jucharick.Tasks.domain.User;

import java.util.List;

public interface UserServiceApi {
    List<User> findAll();
    User findUserById(Integer id);
    User saveUser(User user);
    void deleteById(int id);
    void updateUser(User user);
}
