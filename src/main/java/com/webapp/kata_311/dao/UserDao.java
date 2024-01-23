package com.webapp.kata_311.dao;

import com.webapp.kata_311.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    User get(Long id);

    void delete(long id);

    void update(Long id, User newUser);

    List<User> getAll();

}
