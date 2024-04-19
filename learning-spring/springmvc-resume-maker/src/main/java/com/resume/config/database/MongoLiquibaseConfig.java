package com.resume.config.database;

import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.exception.LiquibaseException;
import liquibase.ext.mongodb.database.MongoLiquibaseDatabase;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:liquibase.properties")
public class MongoLiquibaseConfig {
    private final Environment environment;

    public MongoLiquibaseConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public MongoLiquibaseDatabase mongoLiquibase() throws LiquibaseException {

        MongoLiquibaseDatabase database = (MongoLiquibaseDatabase) DatabaseFactory.getInstance().openDatabase(environment.getProperty("liquibase.mongo.url", ""), environment.getProperty("liquibase.mongo.username", ""), environment.getProperty("liquibase.mongo.password", ""), null, new ClassLoaderResourceAccessor());
        Liquibase liquibase = new Liquibase(environment.getProperty("spring.mongo-liquibase.change-log", ""), new ClassLoaderResourceAccessor(), database);

        if (environment.getProperty("spring.mongo-liquibase.enabled", "").equalsIgnoreCase("true")) {
            liquibase.update("");
        }

        return database;
    }
}
