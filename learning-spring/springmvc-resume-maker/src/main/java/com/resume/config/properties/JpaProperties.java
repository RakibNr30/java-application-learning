package com.resume.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class JpaProperties {
    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dialect;

    @Value("${spring.jpa.show-sql}")
    private String isShowSql;

    @Value("${spring.jpa.format-sql}")
    private String isFormatSql;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAutoMode;

    @Value("${spring.jpa.persistence-unit}")
    private String persistenceUnit;
}
