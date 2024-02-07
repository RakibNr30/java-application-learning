package com.springjdbc.config;

import com.springjdbc.repository.UserRepository;
import com.springjdbc.repository.UserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.springjdbc.repository")
public class JdbcConfig {

    @Bean(name = {"dataSource"}) // no need this @Bean for our impl
    public DataSource getDataSource () {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/springjdbc");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

        return dataSource;
    }

    @Bean(name = {"jdbcTemplate"}) // no need this name for our impl
    public JdbcTemplate getJdbcTemplate () {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(this.getDataSource());

        return jdbcTemplate;
    }

    /* we will use @Autowire that's why we commented this */
    /*@Bean("userRepository")
    public UserRepository getUserRepository() {
        return new UserRepositoryImpl(this.getJdbcTemplate());
    }*/
}
