package com.springcore.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionInjection {
    public static void main(String[] args) {
        ApplicationContext context = new  ClassPathXmlApplicationContext("collectionConfig.xml");

        Student student1 = (Student) context.getBean("student1");
        System.out.println(student1.getId());
        System.out.println(student1.getName());
        System.out.println(student1.getAddresses());
        System.out.println(student1.getMobiles());
        System.out.println(student1.getCourses());
        System.out.println(student1.getProperties());

        System.out.println("===========================");
        for (String mobile: student1.getMobiles()) {
            System.out.println(mobile);
        }
        System.out.println("===========================");
        System.out.println(student1.getCourses().getClass().getName());
    }
}
