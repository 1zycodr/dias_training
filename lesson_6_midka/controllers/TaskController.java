package lesson_6_midka.controllers;

import lesson_6_midka.controllers.interfaces.ITaskController;
import lesson_6_midka.entities.Task;
import lesson_6_midka.entities.User;
import lesson_6_midka.repositories.TaskRepository;

import java.sql.Date;
import java.util.List;

public class TaskController implements ITaskController {
    private final TaskRepository repo;

    public TaskController(TaskRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Task> getUserTasks(User user) {
        return repo.getTasksByUserId(user.getId());
    }

    @Override
    public boolean createTask(Task task, Date start_date, Date post_date) {
        return repo.createTask(task, start_date, post_date);
    }

    @Override
    public boolean updateTask(Task task) {
        return repo.updateTask(task);
    }

    @Override
    public boolean deleteTask(Task task) {
        return repo.deleteTask(task);
    }
}
