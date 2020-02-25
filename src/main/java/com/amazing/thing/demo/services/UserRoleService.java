package com.amazing.thing.demo.services;

import com.amazing.thing.demo.dao.UserRoleDao;
import com.amazing.thing.demo.model.user.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    public UserRole getUserRole(Long id) {
        return userRoleDao.getUserRoleById(id);
    }

    public void createUserRole(UserRole userRole) {
        userRoleDao.createUserRole(userRole);
    }

    public void removeUserRole(Long id) {
        userRoleDao.removeUserRoleById(id);
    }
}
