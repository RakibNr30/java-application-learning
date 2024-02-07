package com.springcore.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        Student student1 = context.getBean("student1", Student.class);
        System.out.println(student1);
        Student student2 = context.getBean("student2", Student.class);
        System.out.println(student2);

    }
}
