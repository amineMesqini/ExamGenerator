package com.exam.dao;

import com.exam.model.User;
import java.util.List;

public interface UserDao {

    void save(User user);

    User findByEmail(String email);

    List<User> findAll();
}