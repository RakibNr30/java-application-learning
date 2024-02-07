package com.hibernate.hql;

import com.hibernate.entity.Student;
import com.hibernate.entity.relation.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class HQL {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = factory.openSession();

        /* HQL */
        Query query1 = session.createQuery("FROM Student");
        List<Student> students = query1.list();

        for (Student student: students) {
            System.out.println(student);
        }

        System.out.println("__________________________________________");

        Query query2 = session.createQuery("FROM Student AS st WHERE st.id = :sid OR st.name LIKE :namelike");
        query2.setParameter("sid", 2);
        query2.setParameter("namelike", "%in%");
        List<Student> students1 = query2.list();

        for (Student student: students1) {
            System.out.println(student);
        }

        System.out.println("__________________________________________");

        Query query3 = session.createQuery("DELETE FROM Student st WHERE st.id = :sid");
        query3.setParameter("sid", 3);

        Transaction tx = session.beginTransaction();
        int result = query3.executeUpdate();
        System.out.println("DELETED: " + result);

        System.out.println("__________________________________________");

        Query query4 = session.createQuery("SELECT q.id AS q_id, q.value AS q_value, a.value AS a_value FROM Question q JOIN q.answers AS a");
        List<Object[]> questions = query4.getResultList();

        for (Object[] question: questions) {
            System.out.println(Arrays.toString(question));
        }

        tx.commit();


        session.close();
        factory.close();
    }
}
