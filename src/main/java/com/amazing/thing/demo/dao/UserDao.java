package com.amazing.thing.demo.dao;

import static com.amazing.thing.demo.constants.SqlConstants.REMOVE_QUERY;
import static com.amazing.thing.demo.constants.SqlConstants.SELECT_QUERY;
import static com.amazing.thing.demo.constants.SqlConstants.USER_CREATION_QUERY;
import static com.amazing.thing.demo.constants.SqlConstants.USER_ID_COLUMN;
import static com.amazing.thing.demo.constants.SqlConstants.USER_TABLE;
import static com.amazing.thing.demo.constants.SqlUtil.prepareSimpleQuery;

import com.amazing.thing.demo.model.user.User;
import com.amazing.thing.demo.row_mappers.UserRowMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDao {

    private static final int DEFAULT_ROLE_ID = 3;

    private final JdbcTemplate jdbcTemplate;
    private final RoleDao roleDao;

    public User getUserById(Long id) {
        String selectQuery = prepareSimpleQuery(SELECT_QUERY, USER_TABLE, USER_ID_COLUMN);
        User user = jdbcTemplate.queryForObject(selectQuery, new UserRowMapper(), id);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user.setRole(roleDao.getRoleForUser(id));
        return user;
    }


    public boolean removeUserById(Long id) {
        return 1 == jdbcTemplate
                .update(prepareSimpleQuery(REMOVE_QUERY, USER_TABLE, USER_ID_COLUMN), id);
    }

    public Long createUser(User source) {
        return jdbcTemplate
                .queryForObject(
                        USER_CREATION_QUERY,
                        Long.class,
                        source.getUsername(),
                        source.getPassword(),
                        source.getAge(),
                        DEFAULT_ROLE_ID);
    }

}
