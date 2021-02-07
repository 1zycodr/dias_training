package lesson_6_midka.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB implements IPostgresDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connUrl = "jdbc:postgresql://localhost:5432/test";

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(connUrl, "postgres", "ghbdtn");
            return con;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
