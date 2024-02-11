package com.hibernate;

import com.hibernate.xmlmap.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class XMLMap {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = factory.openSession();

        Person person = new Person();
        person.setName("A. Rakib");
        person.setCity("Mymensingh");

        Transaction tx = session.beginTransaction();

        session.save(person);

        tx.commit();

        factory.close();
        factory.close();
    }
}
