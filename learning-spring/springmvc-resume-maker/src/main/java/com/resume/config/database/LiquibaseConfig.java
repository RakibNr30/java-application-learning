package com.resume.config.database;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:liquibase.properties")
public class LiquibaseConfig {
    private final Environment environment;

    public LiquibaseConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    SpringLiquibase liquibaseUpdater(DataSource dataSource) {
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setChangeLog(environment.getProperty("spring.liquibase.change-log", ""));

        return springLiquibase;
    }
}
