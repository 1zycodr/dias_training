package lesson_6_midka.repositories;

import lesson_6_midka.database.PostgresDB;
import lesson_6_midka.entities.Task;
import lesson_6_midka.entities.User;
import lesson_6_midka.repositories.interfaces.ITaskRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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

            stmt.setInt(1, task.getUserId());
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
        Connection con = null;
        PreparedStatement stmt = null;
        String query = "UPDATE tasks SET user_id = ?, text = ?, status = ? WHERE id = ?";

        try {
            con = db.getConnection();
            stmt = con.prepareStatement(query);

            stmt.setInt(1, task.getUserId());
            stmt.setString(2, task.getText());
            stmt.setBoolean(3, task.isStatus());
            stmt.setInt(4, task.getId());

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
    public boolean deleteTask(Task task) {
        Connection con = null;
        PreparedStatement stmt = null;
        String query = "DELETE FROM tasks WHERE id = ?";

        try {
            con = db.getConnection();
            stmt = con.prepareStatement(query);

            stmt.setInt(1, task.getId());

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
    public Task getTask(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM tasks WHERE id = ?";

        try {
            con = db.getConnection();
            stmt = con.prepareStatement(query);

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return new Task(
                        id,
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getBoolean(4)
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM tasks";

        try {
            con = db.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            List<Task> tasks = new ArrayList<>();

            while (rs.next()) {
                tasks.add(new Task(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getBoolean(4)
                ));
            }

            return tasks;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }
}
