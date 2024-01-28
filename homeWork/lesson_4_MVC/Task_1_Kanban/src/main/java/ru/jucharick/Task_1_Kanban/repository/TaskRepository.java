package ru.jucharick.Task_1_Kanban.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

import ru.jucharick.Task_1_Kanban.domain.Task;

@Repository
public class TaskRepository {
    //region Поля
    /**
     * JdbcTemplate
     */
    private final JdbcTemplate jdbc;
    //endregion

    //region Конструкторы
    public TaskRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    //endregion

    //region Методы
    /**
     * SELECT *
     */
    public List<Task> findAllTask() {
        String sql = "SELECT * FROM taskTable";
        RowMapper<Task> taskRowMapper = (r, i) -> {
            Task rowObject = new Task();
            rowObject.setId(r.getInt("id"));
            rowObject.setTitle(r.getString("title"));
            rowObject.setDescription(r.getString("description"));
            rowObject.setStatus(r.getString("status"));
            rowObject.setRequestedBy(r.getInt("requestedBy"));
            rowObject.setAssignedBy(r.getInt("assignedBy"));
            rowObject.setAssigneeID(r.getInt("assigneeID"));
            return rowObject;
        };

        return jdbc.query(sql, taskRowMapper);
    }

    /**
     * SELECT WHERE id = ?
     */
    public Task findTask(Integer id){
        String sql = "SELECT * FROM taskTable WHERE id = ?";
        RowMapper<Task> taskRowMapper = (r, i) -> {
            Task rowObject = new Task();
            rowObject.setId(r.getInt("id"));
            rowObject.setTitle(r.getString("title"));
            rowObject.setDescription(r.getString("description"));
            rowObject.setStatus(r.getString("status"));
            rowObject.setRequestedBy(r.getInt("requestedBy"));
            rowObject.setAssignedBy(r.getInt("assignedBy"));
            rowObject.setAssigneeID(r.getInt("assigneeID"));
            return rowObject;
        };
        return jdbc.query(sql, new Object[]{id}, taskRowMapper).stream().findFirst().orElse(null);
    }

    /**
     * SELECT WHERE assigneeID = ?
     * поиск тасков по исполнителю
     */
    public List<Task> findTaskForUsers(Integer idUser){
        String sql = "SELECT * FROM taskTable WHERE assigneeID = ?";
        RowMapper<Task> taskRowMapper = (r, i) -> {
            Task rowObject = new Task();
            rowObject.setId(r.getInt("id"));
            rowObject.setTitle(r.getString("title"));
            rowObject.setDescription(r.getString("description"));
            rowObject.setStatus(r.getString("status"));
            rowObject.setRequestedBy(r.getInt("requestedBy"));
            rowObject.setAssignedBy(r.getInt("assignedBy"));
            rowObject.setAssigneeID(r.getInt("assigneeID"));
            return rowObject;
        };
        return jdbc.query(sql, new Object[]{idUser}, taskRowMapper);
    }

    /**
     * INSERT
     */
    public Task saveTask(Task task) {
        String sql = "INSERT INTO taskTable (title,description,status,requestedBy,assignedBy,assigneeID) VALUES (?, ?, ?, ?, ?, ?)";
        jdbc.update(sql, task.getTitle(), task.getDescription(),task.getStatus(),task.getRequestedBy(), task.getAssignedBy(),task.getAssigneeID());
        return  task;
    }

    /**
     * DELETE WHERE id = ?
     */
    public void deleteTaskById(int id) {
        String sql = "DELETE FROM taskTable WHERE id = ?";
        jdbc.update(sql, id);
    }

    /**
     * UPDATE WHERE id = ?
     */
    public void updateTask(Task task) {
        String sql = "UPDATE taskTable SET title = ?, description = ?, status=?, requestedBy=?, assignedBy=?, assigneeID=?  WHERE id= ?";
        jdbc.update(sql, task.getTitle(), task.getDescription(), task.getStatus(), task.getRequestedBy(), task.getAssignedBy(), task.getAssigneeID(), task.getId());
    }
    //endregion
}