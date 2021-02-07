package lesson_6_midka.repositories;

import lesson_6_midka.database.PostgresDB;
import lesson_6_midka.entities.Task;
import lesson_6_midka.repositories.interfaces.ITaskRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class TaskRepository implements ITaskRepository {
    public final PostgresDB db;

    public TaskRepository(PostgresDB db) {
        this.db = db;
    }

    @Override
    public boolean createTask(Task task) {
        Connection con = null;
        PreparedStatement stmt = null;
        String query = "INSERT INTO tasks (user_id, text, status) VALUES (?,?,?);";

        try {
            con = db.getConnection();
            stmt = con.prepareStatement(query);

            stmt.setInt(1, task.getUser_id());
            stmt.setString(2, task.getText());
            stmt.setBoolean(3, task.isStatus());

            stmt.execute();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

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
