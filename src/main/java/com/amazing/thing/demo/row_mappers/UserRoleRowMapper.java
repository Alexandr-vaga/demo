package com.amazing.thing.demo.row_mappers;


import static com.amazing.thing.demo.constants.SqlConstants.USER_ROLE_ID_COLUMN;
import static com.amazing.thing.demo.constants.SqlConstants.USER_ROLE_RIGHTS_COLUMN;
import static com.amazing.thing.demo.constants.SqlConstants.USER_ROLE_TYPE_COLUMN;

import com.amazing.thing.demo.model.user.RightType;
import com.amazing.thing.demo.model.user.UserRole;
import com.amazing.thing.demo.model.user.UserRoleType;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UserRoleRowMapper implements RowMapper<UserRole> {

    @Override
    public UserRole mapRow(ResultSet resultSet, int i) throws SQLException {
        return UserRole.builder()
                .id(resultSet.getLong(USER_ROLE_ID_COLUMN))
                .roleRight(RightType.valueOf(resultSet.getString(USER_ROLE_RIGHTS_COLUMN)))
                .roleType(UserRoleType.valueOf(resultSet.getString(USER_ROLE_TYPE_COLUMN)))
                .build();
    }
}
