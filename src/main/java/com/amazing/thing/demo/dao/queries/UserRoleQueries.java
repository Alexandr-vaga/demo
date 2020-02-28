package com.amazing.thing.demo.dao.queries;

public final class UserRoleQueries {
    public static final String ROLE_RETRIEVING_QUERY =
            "select * from user_role where user_role_id = ?";
    public static final String ROLE_REMOVING_QUERY =
            "delete from user_role where user_role_id = ?";
    public static final String ROLE_CREATING_QUERY =
            "insert into user_role (role_right, role_type)"
                    + " values (?, ?)"
                    + " returning user_role_id";

    private UserRoleQueries() {
    }
}
