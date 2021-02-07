package lesson_6_midka.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface IPostgresDB {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
