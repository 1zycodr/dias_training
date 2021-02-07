package lesson_6_midka.repositories.interfaces;

import lesson_6_midka.entities.User;

import java.util.List;

public interface IUserRepository {
    boolean createUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
    User getUserById(int id);
    User getUserByUsernamePassword(String username, String password);
    User getUserByUsername(String username);
    List<User> getAllUsers();
}
