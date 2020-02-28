package com.amazing.thing.demo.controllers;

import com.amazing.thing.demo.model.user.Role;
import com.amazing.thing.demo.services.RoleService;
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
@RequestMapping(value = "/roles/")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping(value = "{id}", produces = "application/json")
    public ResponseEntity<Role> getRole(@PathVariable Long id) {
        return ResponseEntity.ok(roleService.getRole(id));
    }

    @PostMapping
    public ResponseEntity<Long> createRole(@RequestBody Role role) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(roleService.createRole(role));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity removeRole(@PathVariable Long id) {
        return roleService.removeRole(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().build();
    }
}
