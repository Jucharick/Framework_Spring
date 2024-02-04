package ru.jucharick.service;

import ru.jucharick.model.User;
import ru.jucharick.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //region Поля
    /**
     * UserRepository
     */
    private final UserRepository userRepository;
    //endregion

    //region Конструкторы
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //endregion

    //region Методы
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findUserById(Integer id){
        return userRepository.findUser(id);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
    //endregion
}