package lesson_6_midka.repositories.interfaces;

import lesson_6_midka.entities.Task;

import java.sql.Date;
import java.util.List;

public interface ITaskRepository {
    boolean createTask(Task task, Date start_date, Date post_date);
    boolean updateTask(Task task);
    boolean deleteTask(Task task);
    Task getTask(int id);
    List<Task> getTasksByUserIdAndDate(Date date, int id);
    List<Task> getTasksByUserId(int id);
    List<Task> getAllTasks();
}
