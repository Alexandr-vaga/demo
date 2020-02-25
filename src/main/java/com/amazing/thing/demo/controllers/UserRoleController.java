package com.amazing.thing.demo.controllers;

import com.amazing.thing.demo.model.user.UserRole;
import com.amazing.thing.demo.services.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/roles/")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping(value = "{id}", produces = "application/json")
    public @ResponseBody UserRole getUserRole(@PathVariable Long id) {
        return userRoleService.getUserRole(id);
    }

    @PostMapping
    public void createUserRole(@RequestBody UserRole userRole) {
        userRoleService.createUserRole(userRole);
    }
}
