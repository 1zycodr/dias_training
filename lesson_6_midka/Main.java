package lesson_6_midka;

import lesson_6_midka.database.PostgresDB;
import lesson_6_midka.entities.Task;
import lesson_6_midka.entities.User;
import lesson_6_midka.repositories.TaskRepository;
import lesson_6_midka.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostgresDB db = new PostgresDB();
        UserRepository repo = new UserRepository(db);

        User user = new User(1,"USERNAME", "password", "email", "M");
//        User user = repo.getUser(4);
        repo.createUser(user);

//        List<User> users = repo.getAllUsers();

       TaskRepository repo2 = new TaskRepository(db);

       Task task1 = new Task(1, "text", true);

       repo2.createTask(task1);



    }
}
