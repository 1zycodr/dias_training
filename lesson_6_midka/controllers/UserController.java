package lesson_6_midka.controllers;

import lesson_6_midka.controllers.interfaces.IUserController;
import lesson_6_midka.entities.Task;
import lesson_6_midka.entities.User;
import lesson_6_midka.repositories.TaskRepository;
import lesson_6_midka.repositories.UserRepository;

import java.util.List;

public class UserController implements IUserController {
    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User authenticateUser(String username, String password) {
        return repo.getUserByUsernamePassword(username, password);
    }

    @Override
    public boolean isUserExist(User user) {
        return repo.getUserByUsername(user.getUsername()) != null;
    }

    @Override
    public boolean createUser(User user) {
        return repo.createUser(user);
    }
}
