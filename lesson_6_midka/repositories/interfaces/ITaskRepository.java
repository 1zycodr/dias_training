package lesson_6_midka.repositories.interfaces;

import lesson_6_midka.entities.Task;

import java.util.List;

public interface ITaskRepository {
    boolean createTask(Task task);
    boolean updateTask(Task task);
    boolean deleteTask(Task task);
    Task getTask(int id);
    List<Task> getAllTasks();
}
