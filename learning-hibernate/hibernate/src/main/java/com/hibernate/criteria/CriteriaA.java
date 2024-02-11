package com.hibernate.criteria;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.*;
import java.util.List;

public class CriteriaA {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);

        Predicate likeAnywherePredicate = builder.like(studentRoot.get("name"), "%Changed%");

        criteriaQuery.where(likeAnywherePredicate);

        List<Student> students = session.createQuery(criteriaQuery).getResultList();

        for (Student student: students) {
            System.out.println(student);
        }

        factory.close();
        factory.close();
    }
}
