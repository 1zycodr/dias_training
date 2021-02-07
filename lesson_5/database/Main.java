package lesson_5.database;


import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String connUrl = "jdbc:postgresql://localhost:5432/test";
        String queryGetUsers = "SELECT * FROM my_user";
        String queryUpdateUsers = "UPDATE my_user SET name = 'USER1' where id = 1;";
        String queryInsertUsers = "INSERT INTO my_user (name, age) VALUES ('user3', 25), ('user4', 32);";
        String queryDeleteUsers = "DELETE FROM my_user WHERE id = 4";

        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(connUrl, "postgres", "dota2tapor");
            stmt = con.createStatement();


            // SELECT
            rs = stmt.executeQuery(queryGetUsers);

           while (rs.next()) {
               System.out.println(rs.getInt("id") + " " + rs.getString(2) + " " + rs.getInt(3));
            }

            // UPDATE
            stmt.executeUpdate(queryUpdateUsers);

            // INSERT
            stmt.executeUpdate(queryInsertUsers);

            // DELETE
            stmt.executeUpdate(queryDeleteUsers);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                stmt.close();
                rs.close();
                con.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}
