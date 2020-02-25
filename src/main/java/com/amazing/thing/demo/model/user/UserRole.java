package com.amazing.thing.demo.model.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRole {

    private Long id;
    private UserRoleType roleType;
    private RightType roleRight;
}
