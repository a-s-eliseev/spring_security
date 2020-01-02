package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    List<User> listUsers();
    void deleteUser(Long id);
    void editUser(User user);
    User getUser(Long id);
}
