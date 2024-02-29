package ru.jucharick.Tasks.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import ru.jucharick.Tasks.domain.User;
import ru.jucharick.Tasks.repository.UserRepository;
import ru.jucharick.Tasks.services.UserServiceApi;

@Service
@AllArgsConstructor
public class iUserService implements UserServiceApi {
    //region Поля
    /**
     * UserRepository
     */
    private final UserRepository userRepository;
    //endregion

    //region Методы
    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }
    @Override
    public User findUserById(Integer id){
        return userRepository.findUser(id);
    }
    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }
    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
    //endregion
}

