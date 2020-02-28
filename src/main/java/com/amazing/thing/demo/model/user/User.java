package com.amazing.thing.demo.model.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long id;
    private Integer age;
    private String username;
    private String password;
    private Role role;
}
