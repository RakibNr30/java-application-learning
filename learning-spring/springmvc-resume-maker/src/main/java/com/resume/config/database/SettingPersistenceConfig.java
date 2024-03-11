package com.resume.config.database;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.resume.repository.setting"},
        entityManagerFactoryRef = "settingEntityManagerFactory",
        transactionManagerRef = "settingTransactionManager"
)
@PropertySource("classpath:application.properties")
public class SettingPersistenceConfig {

    public final Environment environment;

    @Autowired
    public SettingPersistenceConfig(Environment environment) {
        this.environment = environment;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("show_sql", environment.getProperty("spring.jpa.postgresql.show-sql", ""));
        properties.setProperty("format_sql", environment.getProperty("spring.jpa.postgresql.format-sql", ""));
        properties.setProperty("hibernate.dialect", environment.getProperty("spring.jpa.postgresql.properties.hibernate.dialect", ""));
        properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("spring.jpa.postgresql.hibernate.ddl-auto"));

        return properties;
    }

    @Bean
    DataSource settingDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.postgresql2.driver", ""));
        dataSource.setUrl(environment.getProperty("spring.datasource.postgresql2.url", ""));
        dataSource.setUsername(environment.getProperty("spring.datasource.postgresql2.username", ""));
        dataSource.setPassword(environment.getProperty("spring.datasource.postgresql2.password", ""));

        return dataSource;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean settingEntityManagerFactory(@Qualifier("settingDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("com.resume.entity.setting");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setJpaProperties(this.getHibernateProperties());
        emf.setPersistenceUnitName("postgresqldb2");

        return emf;
    }

    @Bean
    TransactionManager settingTransactionManager(@Qualifier("settingEntityManagerFactory") EntityManagerFactory emf) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(emf);

        return jpaTransactionManager;
    }
}
