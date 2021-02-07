package lesson_6_midka.repositories;

import lesson_6_midka.database.PostgresDB;
import lesson_6_midka.entities.Task;
import lesson_6_midka.repositories.interfaces.ITaskRepository;

import java.util.List;

public class TaskRepository implements ITaskRepository {
    public final PostgresDB db;

    public TaskRepository(PostgresDB db) {
        this.db = db;
    }

    @Override
    public boolean createTask(Task task) {
        return false;
    }

    @Override
    public boolean updateTask(Task task) {
        return false;
    }

    @Override
    public boolean deleteTask(Task task) {
        return false;
    }

    @Override
    public Task getTask(int id) {
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return null;
    }
}
