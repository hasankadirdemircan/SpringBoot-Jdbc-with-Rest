package com.hkdemircan.service;

import com.hkdemircan.dao.UserRepository;
import com.hkdemircan.exception.UserNotFoundException;
import com.hkdemircan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUser(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id);
        if(null == user)throw new UserNotFoundException("User not found with id : " + id);
        return userRepository.findById(id);
    }

    @Override
    public void createUser(User user) {
        userRepository.create(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.update(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}
