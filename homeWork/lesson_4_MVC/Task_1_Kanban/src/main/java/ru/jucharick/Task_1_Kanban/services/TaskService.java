package ru.jucharick.Task_1_Kanban.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import ru.jucharick.Task_1_Kanban.domain.Task;
import ru.jucharick.Task_1_Kanban.repository.TaskRepository;

@Service
public class TaskService {
    //region Поля
    /**
     * UserRepository
     */
    private final TaskRepository taskRepository;
    //endregion

    //region Конструкторы
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    //endregion

    //region Методы
    public List<Task> findAllTask(){
        return taskRepository.findAllTask();
    }

    public Task findTaskById(Integer id){
        return taskRepository.findTask(id);
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
