package lesson_6_midka;

import lesson_6_midka.controllers.TaskController;
import lesson_6_midka.controllers.UserController;

import java.util.Scanner;

public class App {
    private final UserController userController;
    private final TaskController taskController;
    private final Scanner sc;

    public App(UserController userController, TaskController taskController) {
        this.userController = userController;
        this.taskController = taskController;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        for(;;) {
            // [1] - Sign In
            // [2] - Sign Up
            // [3] - Exit
        }
    }

    public void signIn() {

    }

    public void signUp() {

    }
}
