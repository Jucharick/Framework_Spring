package ru.jucharick.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.jucharick.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    //region Поля
    /**
     * Список юзеров
     */
    private List<User> users = new ArrayList<>();
    /**
     * JdbcTemplate
     */
    private final JdbcTemplate jdbc;
    //endregion

    //region Конструкторы
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    //endregion

    //region Методы
    public List<User> getUsers() {
        users = allUserFromDB();
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * SELECT *
     */
    public List<User> allUserFromDB() {
        String sql = "SELECT * FROM userTable";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }

    /**
     * INSERT
     */
    public User saveUser(User user) {
        String sql = "INSERT INTO userTable (name,age,email) VALUES (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
        return  user;
    }
    //endregion
}
