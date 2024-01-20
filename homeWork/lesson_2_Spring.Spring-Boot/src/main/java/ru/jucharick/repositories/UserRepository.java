package ru.jucharick.repositories;

import ru.jucharick.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /*
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
    public User findUser(Integer id){
        String sql = "SELECT * FROM userTable WHERE id = ?";
        User getUser = jdbc.queryForObject(sql, new Object[]{id},
                (resultSet, rowNum) ->
                        new User(
                                resultSet.getInt("id"),
                                resultSet.getString("firstName"),
                                resultSet.getString("lastName")
                        )
        );
        return getUser;
    }

    /*
     * INSERT
     */
    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName,lastName) VALUES (?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return  user;
    }

    /*
     * DELETE
     */
    public void deleteById(Integer id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    /*
    * UPDATE
    */
    public void updateUser(User user) {
        String sql = "UPDATE userTable SET firstName = ?, lastName = ? WHERE id=?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
    }
}