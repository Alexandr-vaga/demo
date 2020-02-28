package com.amazing.thing.demo.constants;

public final class SqlUtil {

    private SqlUtil() {
    }

    public static String prepareSimpleQuery(
            String template,
            String tableName,
            String idColumnName) {
        return String.format(template, tableName, idColumnName);
    }
}
