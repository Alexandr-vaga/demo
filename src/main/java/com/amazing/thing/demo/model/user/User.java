package com.amazing.thing.demo.model.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long id;
    private Integer age;
    private String firstName;
    private String lastName;
    private UserRole userRole;
}
