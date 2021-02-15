package lesson_6_midka.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB implements IPostgresDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connUrl = "jdbc:postgresql://localhost:5432/Midka";

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(connUrl, "postgres", "dota2tapor");
            return con;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        PostgresDB db = new PostgresDB();
        try {
            Connection con = db.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
