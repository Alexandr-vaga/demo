package com.amazing.thing.demo.row_mappers;

import static com.amazing.thing.demo.constants.SqlConstants.USER_AGE_COLUMN;
import static com.amazing.thing.demo.constants.SqlConstants.USER_ID_COLUMN;
import static com.amazing.thing.demo.constants.SqlConstants.USER_PASSWORD_COLUMN;
import static com.amazing.thing.demo.constants.SqlConstants.USER_USERNAME_COLUMN;

import com.amazing.thing.demo.model.user.User;
import lombok.RequiredArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        return User.builder()
                .id(resultSet.getLong(USER_ID_COLUMN))
                .age(resultSet.getInt(USER_AGE_COLUMN))
                .username(resultSet.getString(USER_USERNAME_COLUMN))
                .password(resultSet.getString(USER_PASSWORD_COLUMN))
                .build();
    }
}
