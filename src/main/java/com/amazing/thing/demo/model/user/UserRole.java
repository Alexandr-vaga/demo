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
@Table(name = "roles")
class UserRole {

    @Id
    @GeneratedValue
    private Long id;
    private UserRoleType roleType;
    private RightType roleRight;
}
