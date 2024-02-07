package com.hibernate;

import com.hibernate.entity.Student;
import com.hibernate.embed.Certificate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Embedding {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Certificate certificate1 = new Certificate();
        certificate1.setCid(1);
        certificate1.setCname("SSC");

        Certificate certificate2 = new Certificate();
        certificate2.setCid(2);
        certificate2.setCname("HSC");

        Student student1 = new Student();
        student1.setName("Name 01");
        student1.setCertificate(certificate1);

        Student student2 = new Student();
        student2.setName("Name 02");
        student2.setCertificate(certificate2);

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        try {

            session.save(student1);
            session.save(student2);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println(e.getMessage());
        }

        session.close();
        factory.close();
    }
}
