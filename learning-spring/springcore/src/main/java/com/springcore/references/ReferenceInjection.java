package com.springcore.references;

import com.springcore.collections.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReferenceInjection {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("referenceConfig.xml");

        User user1 = (User) context.getBean("user1");
        System.out.println(user1.getId());
        System.out.println(user1.getName());
        System.out.println(user1.getAddress());
        System.out.println("========= Address 1 =========");
        Address address1 = user1.getAddress();
        System.out.println(address1.getId());
        System.out.println(address1.getCity());
        System.out.println(address1.getDivision());
        System.out.println("========= Address 1 End =========");

        User user2 = (User) context.getBean("user2");
        System.out.println(user2);
    }
}
