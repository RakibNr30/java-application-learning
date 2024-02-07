package com.springcore.constructors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjection {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("constructorConfig.xml");

        User user1 = (User) context.getBean("user1");
        System.out.println(user1);
        System.out.println(user1.getId());
        System.out.println("=======================");
        User user2 = (User) context.getBean("user2");
        System.out.println(user2);
        System.out.println(user2.getId());

        System.out.println("============ constructor ambiguity resolve print ============");
        System.out.println("addition1");
        Addition addition1 = (Addition) context.getBean("addition1");
        addition1.doSum();
        addition1.doSub();
        System.out.println("addition2");
        Addition addition2 = (Addition) context.getBean("addition2");
        addition2.doSum();
        addition2.doSub();
        System.out.println("addition3");
        Addition addition3 = (Addition) context.getBean("addition3");
        addition3.doSum();
        addition3.doSub();
    }
}
