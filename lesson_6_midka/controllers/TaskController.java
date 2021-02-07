package lesson_6_midka.controllers;

import lesson_6_midka.repositories.TaskRepository;

public class TaskController {
    private final TaskRepository repo;

    public TaskController(TaskRepository repo) {
        this.repo = repo;
    }
}
