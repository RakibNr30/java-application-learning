package com.springcore.autowire.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireAnnotationInjection {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autowireAnnotationConfig.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee);
        Employee employee1 = context.getBean("employee1", Employee.class);
        System.out.println(employee1);
        Employee employee2 = context.getBean("employee2", Employee.class);
        System.out.println(employee2);
    }
}
