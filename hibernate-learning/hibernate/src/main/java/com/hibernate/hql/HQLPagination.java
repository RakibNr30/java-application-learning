package com.hibernate.hql;

import com.hibernate.entity.relation.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPagination {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        Query<Question> query = session.createQuery("FROM Question ", Question.class);

        /* implementing pagination using hibernate */
        query.setFirstResult(2);
        query.setMaxResults(5);

        List<Question> questions = query.list();

        for (Question question: questions) {
            System.out.println(question);
        }

        session.close();
        factory.close();
    }
}
