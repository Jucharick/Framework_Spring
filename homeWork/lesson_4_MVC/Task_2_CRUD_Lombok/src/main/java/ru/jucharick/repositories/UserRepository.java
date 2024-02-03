package ru.jucharick.repositories;

import lombok.AllArgsConstructor;
import ru.jucharick.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {
    //region Поля
    /**
     * JdbcTemplate
     */
    private final JdbcTemplate jdbc;
    /**
     * Конфигуратор SQL запросов
     */
    private final SQLCMD sqlQuery;
    //endregion

    //region Методы
    /**
     * Получение списка всех пользователей
     */
    public List<User> findAll() {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sqlQuery.getFindAll(), userRowMapper);
    }

    /**
     * Поиск пользователя по id
     */
    public User findUser(Integer id){
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sqlQuery.getGetById(), new Object[]{id}, userRowMapper).stream().findFirst().orElse(null);
    }

    /**
     * Добавление пользователя
     */
    public User save(User user) {
        jdbc.update(sqlQuery.getSave(), user.getFirstName(), user.getLastName());
        return  user;
    }

    /**
     * Удаление пользователя по id
     */
    public void deleteById(int id) {
        jdbc.update(sqlQuery.getDelete(), id);
    }

    /**
     * Обновить данные о пользователе по id
     */
    public void updateUser(User user) {
        jdbc.update(sqlQuery.getUpdate(), user.getFirstName(), user.getLastName(), user.getId());
    }
    //endregion
}