package com.hibernate.sql;

import com.hibernate.entity.relation.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

public class SQL {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        NativeQuery<Object[]> query = session.createSQLQuery("SELECT * FROM questions");

        List<Object[]> objects = query.list();

        for (Object[] questions: objects) {
            System.out.println(questions[0] + " - " + questions[1]);
        }

        session.close();
        factory.close();
    }
}
