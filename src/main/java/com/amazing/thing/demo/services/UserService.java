package com.amazing.thing.demo.services;

import com.amazing.thing.demo.dao.UserDao;
import com.amazing.thing.demo.model.user.User;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public User getUser(Long id) {
        return userDao.getUserById(id);
    }

    public Long createUser(User role) {
        return userDao.createUser(role);
    }

    public boolean removeUser(Long id) {
        return userDao.removeUserById(id);
    }
}
