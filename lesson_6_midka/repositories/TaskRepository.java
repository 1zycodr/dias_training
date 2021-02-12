package lesson_6_midka.repositories;

import lesson_6_midka.database.PostgresDB;
import lesson_6_midka.entities.Task;
import lesson_6_midka.entities.User;
import lesson_6_midka.repositories.interfaces.ITaskRepository;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository implements ITaskRepository {
    public final PostgresDB db;

    public TaskRepository(PostgresDB db) {
        this.db = db;
    }

    @Override
    public boolean createTask(Task task, Date start_date, Date post_date) {
        Connection con = null;
        PreparedStatement stmt = null;
        String query = "INSERT INTO tasks (user_id, text, status, start_date, post_date) VALUES (?,?,?,?,?);";
        ResultSet rs = null;
        Statement stm = null;

        try {
            con = db.getConnection();
            stmt = con.prepareStatement(query);

            stmt.setInt(1, task.getUserId());
            stmt.setString(2, task.getText());
            stmt.setBoolean(3, task.isStatus());
            stmt.setDate(4, start_date);
            stmt.setDate(5, post_date);
            stmt.execute();

            stm = con.createStatement();
            rs = stm.executeQuery("SELECT max(id) FROM tasks;");

            if (rs.next()) {
                task.setId(rs.getInt(1));
            }

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                stm.close();
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
    public List<Task> getTasksByUserIdAndDate(Date date, int id) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM tasks WHERE start_date <= " + date +
                " AND finish_date <= " + date + " AND user_id = " + id;

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

    @Override
    public List<Task> getTasksByUserId(int id) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM tasks WHERE user_id = " + id;

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
                        rs.getBoolean(4),
                        rs.getDate(5),
                        rs.getDate(6)
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
                        rs.getBoolean(4),
                        rs.getDate(5),
                        rs.getDate(6)
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
