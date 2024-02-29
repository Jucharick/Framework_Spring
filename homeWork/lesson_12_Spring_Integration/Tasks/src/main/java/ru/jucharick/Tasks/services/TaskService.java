package ru.jucharick.Tasks.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import ru.jucharick.Tasks.domain.Task;
import ru.jucharick.Tasks.repository.TaskRepository;

@Service
@AllArgsConstructor
public class TaskService {
    //region Поля
    /**
     * UserRepository
     */
    private final TaskRepository taskRepository;
    //endregion

    //region Методы
    public List<Task> findAllTask(){
        return taskRepository.findAllTask();
    }

    public Task findTaskById(Integer id){
        return taskRepository.findTask(id);
    }

    public List<Task> findTaskByUserId(Integer id){
        return taskRepository.findTaskForUsers(id);
    }

    public Task saveTask(Task task){
        return taskRepository.saveTask(task);
    }

    public void deleteById(int id) {
        taskRepository.deleteTaskById(id);
    }

    public void updateTask(Task task) {
        taskRepository.updateTask(task);
    }
    //endregion
}
