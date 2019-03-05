package com.hkdemircan.service;

import com.hkdemircan.exception.UserNotFoundException;
import com.hkdemircan.model.User;

import java.util.List;

public interface UserService {
    List<User> findUsers();
    User findUser(Long id) throws UserNotFoundException;
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
}
