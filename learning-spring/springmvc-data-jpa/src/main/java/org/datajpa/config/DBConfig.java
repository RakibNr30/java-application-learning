package org.datajpa.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.dialect.PostgresPlusDialect;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "org.datajpa.repository")
public class DBConfig {

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/springmvc-data-jpa");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

        return dataSource;
    }

    /*Properties getHibernateProperties() {
        Properties properties = new Properties();
        //properties.setProperty("hibernate.dialect", PostgresPlusDialect.class.getName()); // by defauld
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.show_sql", "true");

        return properties;
    }*/

    @Bean
    /*LocalContainerEntityManagerFactoryBean */
    FactoryBean<EntityManagerFactory> entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(this.dataSource());
        entityManagerFactoryBean.setPackagesToScan("org.datajpa.entity");

        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setShowSql(true);

        entityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        entityManagerFactoryBean.setPersistenceUnitName("postgresqldb"); // otherwise default

        return entityManagerFactoryBean;
    }

    /*@Bean
    EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }*/

    @Bean
    PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        // when use multiple datasource then we should jta transaction manager

        return transactionManager;
    }
}
