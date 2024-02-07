package com.springcore.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.springcore.javaconfig")
public class JavaConfig {

    @Bean
    public Address getAddress() {
        return new Address(1, "Trishal", "Mymensingh");
    }

    @Bean("student1")
    public Student getStudent1 () {

        return new Student(1, "Abdur Rakib", List.of("01XXXXXXXX0", "01XXXXXXXX1"), getAddress());
    }

    @Bean("student2")
    public Student getStudent2 () {
        return new Student(1, "Abdur Rakib 01", List.of("01XXXXXXXX2", "01XXXXXXXX3"), getAddress());
    }
}
