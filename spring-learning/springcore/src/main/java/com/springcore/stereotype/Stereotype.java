package com.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Stereotype {
    public static void main(String[] args) {
        ApplicationContext context = new  ClassPathXmlApplicationContext("stereotypeConfig.xml");

        Student student1 = context.getBean("student1", Student.class);
        System.out.println(student1);
        System.out.println(student1.getFriends().getClass().getName());
        System.out.println(student1.hashCode());
        System.out.println("==============================================================");
        Student student2 = context.getBean("student1", Student.class);
        System.out.println(student2);
        System.out.println(student2.getFriends().getClass().getName());
        System.out.println(student2.hashCode());
        System.out.println("==============================================================");
        Teacher teacher1 = context.getBean("teacher", Teacher.class);
        Teacher teacher2 = context.getBean("teacher", Teacher.class);

        System.out.println(teacher1.hashCode());
        System.out.println(teacher2.hashCode());
    }
}
