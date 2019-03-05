package com.hkdemircan.dao;

import com.hkdemircan.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User icin tum dao islemlerinin gerceklestirilecegi interface
 */
public interface UserRepository {
    List<User> findAll();
    User findById(Long id);

    void create(User user);
    User update(User user);
    void delete(Long id);
}
