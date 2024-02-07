package com.hibernate.cache;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevel {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        /* first session */
        Session session1 = factory.openSession();

        Student student1 = session1.get(Student.class, 1);
        System.out.println(student1);

        session1.close();


        /* second session */
        Session session2 = factory.openSession();

        Student student2 = session2.get(Student.class, 1);
        System.out.println(student2);

        session2.close();

        factory.close();
    }
}
