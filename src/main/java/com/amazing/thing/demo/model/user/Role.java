package com.amazing.thing.demo.model.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Role {

    private Long id;
    private RoleType roleType;
    private RightType roleRight;
}
