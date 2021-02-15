package Homework_5;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        start();
    }

    private static void start() {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        String URL = "jdbc:postgresql://localhost:5432/assignment5";
        String username = "postgres";
        String pass = "dota2tapor";

        System.out.println("1 Library Nur-Sultan\n2 Library Almaty\n3 Exit\n");
        int vybor = scan.nextInt();

        switch (vybor){
            case 1:
                System.out.println("Welcome to Nur-Sultan library\n" +
                        "1 List of book\n" +
                        "2 Choose your book\n" +
                        "3 Borrow your book\n" +
                        "4 Return book to library\n" +
                        "5 See address");
                int dota = scan.nextInt();
                switch (dota){
                    case 1:
                        try{
                            Connection connection = DriverManager.getConnection(URL, username, pass);
                            String sql = "select * from book order by id";

                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(sql);
                            int i=0;

                            while (result.next()){
                                i++;
                                System.out.println(i + " book");
                                String choosed_book = result.getString("name");
                                System.out.println("Name:"+ choosed_book + "\n");

                            }
                            connection.close();
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }
                        System.out.println("GO BACK - 1, NO - 2");
                        if (scan.nextInt() == 1) {
                            start();
                        }
                        break;
                    case 2:
                        try {
                            Connection connection = DriverManager.getConnection(URL, username, pass);
                            String book_name = scan.nextLine();
                            String sql = "SELECT * FROM book where name like ?";
                            System.out.println("Which book do u want?:");
                            String name = scan.nextLine() + "%";
                            PreparedStatement statement1 = connection.prepareStatement(sql);
                            statement1.setString(1,name);

                            ResultSet result = statement1.executeQuery();


                            while (result.next()){
                                System.out.println("Name of book: "+result.getString("name")+"\n"+"Year was printed: "+result.getInt("printyear") + "\n"+"Price of book: " + result.getInt("price")+"\n"+"ID of book: "+result.getInt("id"));
                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println("GO BACK - 1, NO - 2");
                        if (scan.nextInt() == 1) {
                            start();
                        }
                        break;
                    case 3:
                        try {
                            Connection connection = DriverManager.getConnection(URL, username, pass);
                            String sql = "DELETE FROM book WHERE id=?;";
                            String sql1 = "select * from book order by id";

                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(sql1);

                            int i = 0;
                            while (result.next()){
                                i++;
                                System.out.println("ID of book: "+result.getInt("id") + " - " + result.getString("name"));
                            }


                            PreparedStatement statement1 = connection.prepareStatement(sql);
                            System.out.println("ID of book that you want");
                            int id1 = scan.nextInt();

                            String sql3 = "select * from book where id =" + id1;
                            PreparedStatement statement2 = connection.prepareStatement(sql3);

                            ResultSet result3 = statement.executeQuery(sql3);

                            while (result3.next()){


                                String sql5 = "INSERT INTO borow (name, price, printyear, id) " +
                                        "VALUES (?, ?, ?, ?)";
                                PreparedStatement statement3 = connection.prepareStatement(sql3);

                                String name = result3.getString("name");
                                int price = result3.getInt("price");
                                int printyear = result3.getInt("printyear");
                                int id = result3.getInt("id");


                                statement3.setString(1, name);
                                statement3.setInt(2, price);
                                statement3.setInt(3, printyear);
                                statement3.setInt(4, id);
                                int rowsInserted = statement3.executeUpdate();
                                if (rowsInserted > 0) {
                                    System.out.println("Your rented succes");
                                }
                            }

                            statement1.setInt(1, id1);

                            int rowsInserted = statement1.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("Success!");
                            }

                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println("GO BACK - 1, NO - 2");
                        if (scan.nextInt() == 1) {
                            start();
                        }

                        break;
                    case 4:
                        try {

                            Connection connection = DriverManager.getConnection(URL, username, pass);
                            String sql = "DELETE FROM borrow WHERE id=?;";
                            String sql1 = "select * from borrow order by id";


                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(sql1);

                            while (result.next()){
                                System.out.println("ID: "+result.getInt("id")+"-"+result.getString("name"));
                            }


                            PreparedStatement statement1 = connection.prepareStatement(sql);
                            System.out.println("ID of book");

                            int id2 = scan.nextInt();


                            String sql2 = "select * from borrow where id =" + id2;
                            PreparedStatement statement2 = connection.prepareStatement(sql2);

                            ResultSet result1 = statement.executeQuery(sql2);

                            while (result1.next()){


                                String sql3 = "INSERT INTO book (name, price, printyear, id) " +
                                        "VALUES (?, ?, ?, ?)";
                                PreparedStatement statement3 = connection.prepareStatement(sql3);

                                String name = result1.getString("name");
                                String price = result1.getString("price");
                                int printyear = result1.getInt("printyear");
                                int id = result1.getInt("id");

                                statement3.setString(1, name);
                                statement3.setString(2, price);
                                statement3.setInt(3, printyear);
                                statement3.setInt(4, id);
                                int rowsInserted = statement3.executeUpdate();
                                if (rowsInserted > 0) {
                                    System.out.println("Return success");
                                }
                            }

                            statement1.setInt(1, id2);

                            int rowsInserted = statement1.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("Success!");
                            }

                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println("GO BACK - 1, NO - 2");
                        if (scan.nextInt() == 1) {
                            start();
                        }

                        break;
                    case 5:
                        try {
                            Connection connection = DriverManager.getConnection(URL, username, pass);
                            String sql = "select * from library where id=1";

                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(sql);
                            int i=0;

                            while (result.next()){
                                String address = result.getString("address");
                                System.out.println("Nur-Sultan library address: " + address + ", works 9 AM to 5 PM daily");
                            }

                            connection.close();
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }
                        break;
                }
                break;

            case 2:
                System.out.println("Welcome to Almaty library\n" +
                        "1 List of book\n" +
                        "2 Choose your book\n" +
                        "3 Borrow your book\n" +
                        "4 Return book to library\n" +
                        "5 See address\n");
                int dota2 = scan.nextInt();
                switch (dota2){
                    case 1:
                        try{
                            Connection connection = DriverManager.getConnection(URL, username, pass);
                            String sql = "select * from book2 order by id";

                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(sql);
                            int i=0;

                            while (result.next()){
                                i++;
                                System.out.println(i + " Book");
                                String book_name = result.getString("name");
                                System.out.println("Name:"+ book_name + "\n");

                            }
                            connection.close();
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }
                        System.out.println("GO BACK - 1, NO - 2");
                        if (scan.nextInt() == 1) {
                            start();
                        }
                        break;
                    case 2:

                        try {
                            Connection connection = DriverManager.getConnection(URL, username, pass);
                            String bookname = scan.nextLine();
                            String sql = "SELECT * FROM book2 where name like ?";
                            System.out.println("Write the book name:");
                            String name = scan.nextLine() + "%";
                            PreparedStatement statement = connection.prepareStatement(sql);
                            statement.setString(1,name);
                            ResultSet result = statement.executeQuery();


                            while (result.next()){
                                System.out.println("Name of book: "+result.getString("name")+"\n"+"Price: "+result.getInt("price")+"\n"+"Print year: "+result.getInt("printyear")+"\n"+"ID: "+result.getInt("id"));
                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println("GO BACK - 1, NO - 2");
                        if (scan.nextInt() == 1) {
                            start();
                        }
                        break;
                    case 3:

                        try {




                            Connection connection = DriverManager.getConnection(URL, username, pass);
                            String sql = "DELETE FROM book2 WHERE id=?;";
                            String sql1 = "select * from book2 order by id";




                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(sql1);

                            int i = 0;
                            while (result.next()){
                                i++;
                                System.out.println("ID: "+result.getInt("id")+"-"+result.getString("name"));
                            }


                            PreparedStatement statement1 = connection.prepareStatement(sql);
                            System.out.println("Write ID of book");
                            int id3 = scan.nextInt();

                            String sql2 = "select * from book2 where id =" + id3;
                            PreparedStatement statement2 = connection.prepareStatement(sql2);

                            ResultSet result1 = statement.executeQuery(sql2);

                            while (result1.next()){


                                String sql3 = "INSERT INTO borow2 (name, price, printyear, id) " +
                                        "VALUES (?, ?, ?, ?)";
                                PreparedStatement statement3 = connection.prepareStatement(sql3);

                                String name = result1.getString("name");
                                String price = result1.getString("price");
                                int printyear = result1.getInt("printyear");
                                int id = result1.getInt("id");


                                statement3.setString(1, name);
                                statement3.setString(2, price);
                                statement3.setInt(3, printyear);
                                statement3.setInt(4, id);
                                int rowsInserted = statement3.executeUpdate();
                                if (rowsInserted > 0) {
                                    System.out.println("Rent success");
                                }
                            }

                            statement1.setInt(1, id3);
                            int rowsInserted = statement1.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("Success!");
                            }

                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println("GO BACK - 1, NO - 2");
                        if (scan.nextInt() == 1) {
                            start();
                        }
                        break;
                    case 4:
                        try {
                            Connection connection = DriverManager.getConnection(URL, username, pass);
                            String sql = "DELETE FROM borow2 WHERE id=?;";
                            String sql1 = "select * from borow2 order by id";


                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(sql1);

                            while (result.next()){
                                System.out.println("ID: "+result.getInt("id")+"-"+result.getString("name"));
                            }


                            PreparedStatement statement1 = connection.prepareStatement(sql);
                            System.out.println("Write ID of book that you want return");
                            int id5 = scan.nextInt();

                            String sql2 = "select * from borow2 where id =" + id5;
                            PreparedStatement statement2 = connection.prepareStatement(sql2);

                            ResultSet result1 = statement.executeQuery(sql2);

                            while (result1.next()){


                                String sql3 = "INSERT INTO book2 (name, price, printyear, id) " +
                                        "VALUES (?, ?, ?, ?)";
                                PreparedStatement statement3 = connection.prepareStatement(sql3);

                                String name = result1.getString("name");
                                String price = result1.getString("price");
                                int printyear = result1.getInt("printyear");
                                int id = result1.getInt("id");


                                statement3.setString(1, name);
                                statement3.setString(2, price);
                                statement3.setInt(3, printyear);
                                statement3.setInt(4, id);
                                int rowsInserted = statement3.executeUpdate();
                                if (rowsInserted > 0) {
                                    System.out.println("Return success");
                                }
                            }

                            statement1.setInt(1, id5);

                            int rowsInserted = statement1.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("Success!");
                            }

                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println("GO BACK - 1, NO - 2");
                        if (scan.nextInt() == 1) {
                            start();
                        }

                        break;
                    case 5:
                        try {
                            Connection connection = DriverManager.getConnection(URL, username, pass);
                            String sql = "select * from library where id=2";

                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(sql);
                            int i=0;

                            while (result.next()){
                                String address = result.getString("address");
                                System.out.println("Almaty library address: "+address+", works 9 AM to 5 PM daily");
                            }

                            connection.close();
                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }
                        break;
                }
                break;
            case 3:
                System.exit(1);
                break;
            default:
                System.out.println("Invalid input");
        }}}
