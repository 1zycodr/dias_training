package lesson_6_midka.controllers;

import lesson_6_midka.repositories.TaskRepository;
import lesson_6_midka.repositories.UserRepository;

public class UserController {
    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }
}
