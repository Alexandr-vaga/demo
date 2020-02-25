package com.amazing.thing.demo.dao;

import static com.amazing.thing.demo.constants.SqlConstants.USER_ROLE_ID_COLUMN;
import static com.amazing.thing.demo.constants.SqlConstants.USER_ROLE_RIGHTS_COLUMN;
import static com.amazing.thing.demo.constants.SqlConstants.USER_ROLE_TABLE;
import static com.amazing.thing.demo.constants.SqlConstants.USER_ROLE_TYPE_COLUMN;

import com.amazing.thing.demo.model.user.UserRole;
import com.amazing.thing.demo.row_mappers.UserRoleRowMapper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDao {

    private static final String ROLE_RETRIEVING_QUERY =
            "select * from user_role where user_role_id = ?";
    private static final String ROLE_REMOVING_QUERY =
            "delete from user_role where user_role_id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    public UserRole getUserRoleById(Long id) {
        return jdbcTemplate.queryForObject(
                ROLE_RETRIEVING_QUERY,
                new Object[]{id},
                new UserRoleRowMapper());
    }

    public void removeUserRoleById(Long id) {
        jdbcTemplate.execute(ROLE_REMOVING_QUERY);
    }

    public void createUserRole(UserRole source) {
        simpleJdbcInsert.withTableName(USER_ROLE_TABLE)
                .usingGeneratedKeyColumns(USER_ROLE_ID_COLUMN)
                .execute(prepareParamsForNewUserRole(source));
    }

    private Map<String, Object> prepareParamsForNewUserRole(UserRole source) {
        Map<String, Object> target = new HashMap<>();
        target.put(USER_ROLE_RIGHTS_COLUMN, source.getRoleRight());
        target.put(USER_ROLE_TYPE_COLUMN, source.getRoleType());
        return target;
    }

}
