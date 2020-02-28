package com.amazing.thing.demo.controllers;

import com.amazing.thing.demo.model.user.User;
import com.amazing.thing.demo.services.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "{id}", produces = "application/json")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody User role) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(role));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity removeUser(@PathVariable Long id) {
        return userService.removeUser(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().build();
    }
}
