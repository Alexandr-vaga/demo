package com.amazing.thing.demo.services;

import com.amazing.thing.demo.dao.RoleDao;
import com.amazing.thing.demo.model.user.Role;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleDao roleDao;

    public Role getRole(Long id) {
        return roleDao.getRoleById(id);
    }

    public Long createRole(Role role) {
        return roleDao.createRole(role);
    }

    public boolean removeRole(Long id) {
        return roleDao.removeRoleById(id);
    }
}
