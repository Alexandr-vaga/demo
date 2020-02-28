package com.amazing.thing.demo.row_mappers;


import static com.amazing.thing.demo.constants.SqlConstants.ROLE_ID_COLUMN;
import static com.amazing.thing.demo.constants.SqlConstants.ROLE_RIGHTS_COLUMN;
import static com.amazing.thing.demo.constants.SqlConstants.ROLE_TYPE_COLUMN;

import com.amazing.thing.demo.model.user.RightType;
import com.amazing.thing.demo.model.user.Role;
import com.amazing.thing.demo.model.user.RoleType;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleRowMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet resultSet, int i) throws SQLException {
        return Role.builder()
                .id(resultSet.getLong(ROLE_ID_COLUMN))
                .roleRight(RightType.valueOf(resultSet.getString(ROLE_RIGHTS_COLUMN)))
                .roleType(RoleType.valueOf(resultSet.getString(ROLE_TYPE_COLUMN)))
                .build();
    }
}
