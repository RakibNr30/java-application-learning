package com.springcore.collections.standalone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StandaloneCollection {
    public static void main(String[] args) {
        ApplicationContext context = new  ClassPathXmlApplicationContext("standaloneCollectionConfig.xml");

        Student student1 = context.getBean("student1", Student.class);
        Student student2 = context.getBean("student2", Student.class);

        System.out.println(student1);
        System.out.println("List Class" + student1.getFriends().getClass().getName());
        System.out.println("Map Class" + student1.getCourseFees().getClass().getName());
        System.out.println("Properties Class" + student1.getProperties().getClass().getName());
        System.out.println(student2);
        System.out.println("List Class" + student2.getFriends().getClass().getName());
        System.out.println("Map Class" + student2.getCourseFees().getClass().getName());
        System.out.println("Properties Class" + student2.getProperties().getClass().getName());
    }
}
