package com.amazing.thing.demo.dao;

import static com.amazing.thing.demo.constants.SqlConstants.REMOVE_QUERY;
import static com.amazing.thing.demo.constants.SqlConstants.ROLE_CREATION_QUERY;
import static com.amazing.thing.demo.constants.SqlConstants.ROLE_ID_COLUMN;
import static com.amazing.thing.demo.constants.SqlConstants.ROLE_JOINING_QUERY;
import static com.amazing.thing.demo.constants.SqlConstants.ROLE_TABLE;
import static com.amazing.thing.demo.constants.SqlConstants.SELECT_QUERY;
import static com.amazing.thing.demo.constants.SqlUtil.prepareSimpleQuery;

import com.amazing.thing.demo.model.user.Role;
import com.amazing.thing.demo.row_mappers.RoleRowMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleDao {

    private final JdbcTemplate jdbcTemplate;

    public Role getRoleById(Long id) {
        return jdbcTemplate
                .queryForObject(
                        prepareSimpleQuery(SELECT_QUERY, ROLE_TABLE, ROLE_ID_COLUMN),
                        new RoleRowMapper(),
                        id);
    }

    public boolean removeRoleById(Long id) {
        // returns 1 if operation was successful
        return 1 == jdbcTemplate
                .update(prepareSimpleQuery(REMOVE_QUERY, ROLE_TABLE, ROLE_ID_COLUMN), id);
    }

    public Long createRole(Role source) {
        return jdbcTemplate
                .queryForObject(
                        ROLE_CREATION_QUERY,
                        Long.class,
                        source.getRoleRight().name(),
                        source.getRoleType().name());
    }

    Role getRoleForUser(Long userId) {
        return jdbcTemplate.queryForObject(ROLE_JOINING_QUERY, new RoleRowMapper(), userId);
    }

}
