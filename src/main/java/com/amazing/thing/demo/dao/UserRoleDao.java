package com.amazing.thing.demo.dao;

import static com.amazing.thing.demo.dao.queries.UserRoleQueries.ROLE_CREATING_QUERY;
import static com.amazing.thing.demo.dao.queries.UserRoleQueries.ROLE_REMOVING_QUERY;
import static com.amazing.thing.demo.dao.queries.UserRoleQueries.ROLE_RETRIEVING_QUERY;

import com.amazing.thing.demo.model.user.UserRole;
import com.amazing.thing.demo.row_mappers.UserRoleRowMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// Used only spring JDBCTemplate cause of lowest level and maybe better speed
@Slf4j
@Repository
public class UserRoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserRole getUserRoleById(Long id) {
        return jdbcTemplate.queryForObject(ROLE_RETRIEVING_QUERY, new UserRoleRowMapper(), id);
    }

    public boolean removeUserRoleById(Long id) {
        // returns 1 when operation was successful
        return 1 == jdbcTemplate.update(ROLE_REMOVING_QUERY, id);
    }

    public Long createUserRole(UserRole source) {
        return jdbcTemplate.queryForObject(
                ROLE_CREATING_QUERY,
                Long.class,
                source.getRoleRight().name(),
                source.getRoleType().name());
    }

}
