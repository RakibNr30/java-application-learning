package com.hibernate.cascade;

import com.hibernate.entity.relation.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class Cascade {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Question question = session.get(Question.class, 3);

        if (question != null)
            session.delete(question);

        tx.commit();

        session.close();
        factory.close();
    }
}
