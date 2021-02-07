package lesson_6_midka.repositories;

import lesson_6_midka.database.PostgresDB;
import lesson_6_midka.entities.User;
import lesson_6_midka.repositories.interfaces.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    public final PostgresDB db;

    public UserRepository(PostgresDB db) {
        this.db = db;
    }

    @Override
    public boolean createUser(User user) {
        Connection con = null;
        PreparedStatement stmt = null;
        String query = "INSERT INTO users (username, password, email, gender) VALUES (?,?,?,?);";

        try {
            con = db.getConnection();
            stmt = con.prepareStatement(query);

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getGender());

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
    public boolean updateUser(User user) {
        Connection con = null;
        PreparedStatement stmt = null;
        String query = "UPDATE users SET username = ?, password = ?, email = ?, gender = ? WHERE id = ?";

        try {
            con = db.getConnection();
            stmt = con.prepareStatement(query);

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getGender());
            stmt.setInt(5, user.getId());

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
    public boolean deleteUser(User user) {
        Connection con = null;
        PreparedStatement stmt = null;
        String query = "DELETE FROM users WHERE id = ?";

        try {
            con = db.getConnection();
            stmt = con.prepareStatement(query);

            stmt.setInt(1, user.getId());

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
    public User getUser(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM users WHERE id = ?";

        try {
            con = db.getConnection();
            stmt = con.prepareStatement(query);

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(
                        id,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
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
    public List<User> getAllUsers() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM users";

        try {
            con = db.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            List<User> users = new ArrayList<>();

            while (rs.next()) {
                users.add(new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }

            return users;
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
