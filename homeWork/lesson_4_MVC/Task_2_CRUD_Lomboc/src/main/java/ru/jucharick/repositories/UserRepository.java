package ru.jucharick.repositories;

import ru.jucharick.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    //region Поля
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
    /**
     * SELECT *
     */
    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    /**
     * SELECT WHERE id = ?
     */
    public User findUser(Integer id){
        String sql = "SELECT * FROM userTable WHERE id = ?";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sql, new Object[]{id}, userRowMapper).stream().findFirst().orElse(null);
    }

    /**
     * INSERT
     */
    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName,lastName) VALUES (?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return  user;
    }

    /**
     * DELETE WHERE id = ?
     */
    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id = ?";
        jdbc.update(sql, id);
    }

    /**
     * UPDATE WHERE id = ?
     */
    public void updateUser(User user) {
        String sql = "UPDATE userTable SET firstName = ?, lastName = ? WHERE id= ?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
    }
    //endregion
}