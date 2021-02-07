package lesson_6_midka;

import lesson_6_midka.controllers.TaskController;
import lesson_6_midka.controllers.UserController;
import lesson_6_midka.entities.Task;
import lesson_6_midka.entities.User;
import lesson_6_midka.exceptions.InvalidInputException;

import java.util.InputMismatchException;
import java.util.List;
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
            System.out.println("\n-------------- Main Menu --------------");
            System.out.println("[1] - Sign In\n[2] - Sign Up\n[3] - Exit");

            for(;;) {
                System.out.print("Enter option: ");
                try {
                    int userInput = sc.nextInt();

                    switch (userInput) {
                        case 1:
                            signIn(); return;
                        case 2:
                            signUp(); return;
                        case 3:
                            System.out.println("Goodbye!");
                            System.exit(0);
                        default:
                            throw new InvalidInputException();
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Error! Input must be integer number!");
                    sc.nextLine();
                } catch (InvalidInputException ex) {
                    System.out.println("Error! Invalid input!");
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void signIn() {
        String username, password;

        for(;;) {
            System.out.println("\n-------------- Sign In --------------");
            System.out.print("Enter username (-1 - cancel): ");
            username = sc.next();

            if (username.equals("-1")) {
                start();
            }

            System.out.print("Enter password (-1 - cancel): ");
            password = sc.next();

            if (password.equals("-1")) {
                start();
            }

            User user = userController.authenticateUser(username, password);

            if (user == null) {
                System.out.println("Username or password are invalid!");
            } else {
                userMenu(user);
            }
        }
    }

    public void signUp() {
        String username, password, email, gender;

        for(;;) {
            System.out.println("\n-------------- Sign Up --------------");
            System.out.print("Enter username (-1 - cancel): ");
            username = sc.next();

            if (username.equals("-1")) {
                start();
            }

            System.out.print("Enter password (-1 - cancel): ");
            password = sc.next();

            if (password.equals("-1")) {
                start();
            }

            System.out.print("Enter email (-1 - cancel): ");
            email = sc.next();

            if (email.equals("-1")) {
                start();
            }

            System.out.print("Enter gender (-1 - cancel): ");
            gender = sc.next();

            if (gender.equals("-1")) {
                start();
            }

            User user = new User(username, password, email, gender);

            if (userController.isUserExist(user)) {
                System.out.println("Such user already exists!");
            } else {
                if (userController.createUser(user)) {
                    userMenu(user);
                } else {
                    System.out.println("Error!");
                    start();
                }
            }
        }
    }

    public void userMenu(User user) {
        // [id: 1, status: done] text
        // [id: 1, status: done] text
        // [1] - Add TODO item
        // [2] - Done task
        // [3] - Undone task
        // [4] - Delete task
        // [5] - Logout

        int taskId;
        boolean isExist;

        for(;;) {
            System.out.println("\n-------------- User Menu --------------");
            List<Task> userTasks = taskController.getUserTasks(user);

            System.out.println("Your tasks: ");

            userTasks.forEach(
                    a -> System.out.println(
                            "[id: " + a.getId() +
                                    ", status: " +
                                    (a.isStatus() == true ? "done" : "undone") +
                                    "] " + a.getText())
            );

            if (userTasks.size() == 0) {
                System.out.println("You have not tasks!");
            }

            System.out.println("\n[1] - Add TODO task\n" +
                    "[2] - Done task\n[3] - Undone task\n" +
                    "[4] - Delete task\n[5] - Logout");

            for(;;) {
                System.out.print("Enter option: ");
                try {
                    int userInput = sc.nextInt();

                    switch (userInput) {
                        case 1:
                            System.out.print("Enter text: ");
                            sc.nextLine();
                            String todoText = sc.nextLine();
                            Task newTask = new Task(user.getId(), todoText, false);
                            if (taskController.createTask(newTask)) {
                                System.out.println("Task created!");
                                userMenu(user);
                            } else {
                                System.out.println("Error!");
                            }
                            break;
                        case 2:
                            System.out.print("Enter task id: ");
                            taskId = sc.nextInt();
                            isExist = false;

                            for(Task task: userTasks) {
                                if (task.getId() == taskId) {
                                    isExist = true;

                                    if (task.isStatus()) {
                                        System.out.println("Task already done!");
                                        break;
                                    } else {
                                        task.setStatus(true);
                                        if (taskController.updateTask(task)) {
                                            System.out.println("Task have been done!");
                                            userMenu(user);
                                        } else {
                                            System.out.println("Error!");
                                        }
                                    }
                                }
                            }

                            if(!isExist) {
                                System.out.println("Invalid task id!");
                            }

                            break;
                        case 3:
                            System.out.print("Enter task id: ");
                            taskId = sc.nextInt();
                            isExist = false;

                            for(Task task: userTasks) {
                                if (task.getId() == taskId) {
                                    isExist = true;

                                    if (!task.isStatus()) {
                                        System.out.println("Task already undone!");
                                        break;
                                    } else {
                                        task.setStatus(false);
                                        if (taskController.updateTask(task)) {
                                            System.out.println("Task have been undone!");
                                            userMenu(user);
                                        } else {
                                            System.out.println("Error!");
                                        }
                                    }
                                }
                            }

                            if(!isExist) {
                                System.out.println("Invalid task id!");
                            }

                            break;
                        case 4:
                            System.out.print("Enter task id: ");
                            taskId = sc.nextInt();
                            isExist = false;

                            for(Task task: userTasks) {
                                if (task.getId() == taskId) {
                                    isExist = true;

                                    if (taskController.deleteTask(task)) {
                                        System.out.println("Task deleted!");
                                        userMenu(user);
                                    } else {
                                        System.out.println("Error!");
                                    }
                                }
                            }

                            if(!isExist) {
                                System.out.println("Invalid task id!");
                            }

                            break;
                        case 5:
                            start();
                        default:
                            throw new InvalidInputException();
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Error! Input must be integer number!");
                    sc.nextLine();
                } catch (InvalidInputException ex) {
                    System.out.println("Error! Invalid input!");
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}