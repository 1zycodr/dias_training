package lesson_6_midka.controllers.interfaces;

import lesson_6_midka.entities.Task;
import lesson_6_midka.entities.User;

import java.util.List;

public interface IUserController {
    User authenticateUser(String username, String password);
    boolean isUserExist(User user);
    boolean createUser(User user);
}
