package com.amazing.thing.demo.configs;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

@Configuration
public class DataConfiguration {

    @Bean
    SimpleJdbcInsert simpleJdbcInsert(DataSource dataSource) {
        return new SimpleJdbcInsert(dataSource);
    }

    @Bean
    SimpleJdbcCall simpleJdbcCall(DataSource dataSource) {
        return new SimpleJdbcCall(dataSource);
    }
}
