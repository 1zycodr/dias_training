package lesson_6_midka.controllers.interfaces;

import lesson_6_midka.entities.Task;
import lesson_6_midka.entities.User;

import java.sql.Date;
import java.util.List;

public interface ITaskController {
    List<Task> getUserTasks(User user);
    boolean createTask(Task task, Date start_date, Date post_date);
    boolean updateTask(Task task);
    boolean deleteTask(Task task);
}
