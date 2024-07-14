package com.rcm.services.impl;

import com.rcm.entities.User;
import com.rcm.repositories.UserRepository;
import com.rcm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService  {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User update(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getUserId());
        if (optionalUser.isPresent()) {
           User oldUser = optionalUser.get();
           oldUser.update(user);
           return userRepository.save(oldUser);
        }
        return null;
    }

    @Override
    public Optional<User> delete(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.ifPresent(user -> userRepository.delete(user));
        return optionalUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean canLogin(String username, String password) {
        return userRepository.findByEmailAndPassword(username, password) != null;
    }
}
