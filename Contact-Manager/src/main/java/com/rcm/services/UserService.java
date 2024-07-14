package com.rcm.services;

import com.rcm.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);
    Optional<User> getUserById(int id);
    User update(User user);
    Optional<User> delete(int id);
    List<User> getAllUsers();
    boolean canLogin(String username, String password);

}
