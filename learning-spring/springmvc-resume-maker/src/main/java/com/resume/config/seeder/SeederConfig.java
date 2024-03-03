package com.resume.config.seeder;

import com.resume.seeder.RoleDataSeeder;
import com.resume.seeder.UserDataSeeder;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeederConfig {

    private final RoleDataSeeder roleDataSeeder;

    private final UserDataSeeder userDataSeeder;


    @Autowired
    public SeederConfig(RoleDataSeeder roleDataSeeder, UserDataSeeder userDataSeeder) {
        this.roleDataSeeder = roleDataSeeder;
        this.userDataSeeder = userDataSeeder;
    }

    @PostConstruct
    public void seed() {
        this.roleDataSeeder.seedData();
        this.userDataSeeder.seedData();
    }
}
