package com.amazing.thing.demo.constants;

// In the future will useful implementation of the query builder.
public final class SqlConstants {
    // Role columns
    public static final String ROLE_TABLE = "roles";
    public static final String ROLE_ID_COLUMN = "role_id";
    public static final String ROLE_TYPE_COLUMN = "role_type";
    public static final String ROLE_RIGHTS_COLUMN = "role_right";

    // Role custom queries
    public static final String ROLE_CREATION_QUERY =
            "insert into roles (role_right, role_type)"
                    + " values (?, ?)"
                    + " returning role_id";
    public static final String ROLE_JOINING_QUERY =
            "select * from roles"
            + " inner join users"
            + " on role_id = users_role__fk"
            + " where user_id = ?";

    // User columns
    public static final String USER_TABLE = "users";
    public static final String USER_AGE_COLUMN="age";
    public static final String USER_ID_COLUMN="user_id";
    public static final String USER_USERNAME_COLUMN="username";
    public static final String USER_PASSWORD_COLUMN="password";

    // User custom queries
    public static final String USER_CREATION_QUERY =
            "insert into users (username, password, age, users_role__fk)"
                    + " values (?, ?, ?, ?)"
                    + " returning user_id";

    // Simple queries samples
    public static final String SELECT_QUERY =
            "select * from %s where %s = ?";
    public static final String REMOVE_QUERY =
            "delete from %s where %s = ?";

    private SqlConstants() {
    }
}
