package lesson_6_midka;

import lesson_6_midka.controllers.TaskController;
import lesson_6_midka.controllers.UserController;
import lesson_6_midka.database.PostgresDB;
import lesson_6_midka.repositories.TaskRepository;
import lesson_6_midka.repositories.UserRepository;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PostgresDB db = new PostgresDB();

        TaskRepository taskRepository = new TaskRepository(db);
        TaskController taskController = new TaskController(taskRepository);

        UserRepository userRepository = new UserRepository(db);
        UserController userController = new UserController(userRepository);

        App app = new App(userController, taskController);
        app.start();



    }
}
