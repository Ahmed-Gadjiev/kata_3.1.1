package com.webapp.kata_311.service;

import com.webapp.kata_311.dao.UserDao;
import com.webapp.kata_311.model.User;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User get(long id) {
        return userDao.get(id);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void update(Long id, User newUser) {
        userDao.update(id, newUser);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
