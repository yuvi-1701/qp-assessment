package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    // Mock database connection string for H2 in-memory database
    private final String DbUrl = "jdbc:h2:mem:testdb";
    private final String DbUsername = "username";
    private final String DbPassword = "password";

    // Bean definition for DataSource using DriverManagerDataSource
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl(DbUrl);
        dataSource.setUsername(DbUsername);
        dataSource.setPassword(DbPassword);
        return dataSource;
    }

    // Other configurations or beans can be added here
}
