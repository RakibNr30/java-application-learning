package com.resume.config.seeder;

import com.resume.seeder.RoleDataSeeder;
import com.resume.seeder.UserDataSeeder;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@DependsOn("liquibase")
@PropertySource("classpath:application.properties")
public class SeederConfig {

    private final Environment environment;

    private final RoleDataSeeder roleDataSeeder;

    private final UserDataSeeder userDataSeeder;


    @Autowired
    public SeederConfig(Environment environment, RoleDataSeeder roleDataSeeder, UserDataSeeder userDataSeeder) {
        this.environment = environment;
        this.roleDataSeeder = roleDataSeeder;
        this.userDataSeeder = userDataSeeder;
    }

    @PostConstruct
    public void seed() {
        if (environment.getProperty("spring.data-seed.enabled", "").equalsIgnoreCase("true")) {
            this.seedData();
        }
    }

    private void seedData() {
        this.roleDataSeeder.seedData();
        this.userDataSeeder.seedData();
    }
}
