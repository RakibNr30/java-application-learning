package com.hibernate.cache;

import com.hibernate.entity.relation.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevel {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        /* by default enabled */
        Question question1 = session.get(Question.class, 1);
        System.out.println(question1);

        System.out.println("============================");

        Question question2 = session.get(Question.class, 1);
        System.out.println(question2);

        System.out.println("============================");

        Question question3 = session.get(Question.class, 1);
        System.out.println(question3);

        System.out.println("============================");

        System.out.println(session.contains(question1));
        System.out.println(session.contains(question2));
        System.out.println(session.contains(question3));

        session.close();
        factory.close();
    }
}
