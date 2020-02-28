package com.amazing.thing.demo.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataConfiguration {

    // Source for the users scheme

    @Bean(name = "usersSource")
    @ConfigurationProperties(prefix = "secondary.datasource")
    DataSource usersDataSource() {
        return DataSourceBuilder.create().build();
    }

    // Source for the main scheme
    @Bean(name = "mainSource")
    @ConfigurationProperties(prefix = "primary.datasource")
    DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();

    }

    @Bean
    JdbcTemplate jdbcTemplate(@Qualifier("usersSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
