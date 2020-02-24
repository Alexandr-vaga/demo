package com.amazing.thing.demo.model.user;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private Integer age;
    private String firstName;
    private String lastName;
    private UserRole userRole;
}
