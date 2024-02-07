package com.hibernate;

import com.hibernate.entity.Student;
import com.hibernate.entity.StudentBasic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        Student student = session.get(Student.class, 3); // if not found then null return
        StudentBasic studentBasic = session.load(StudentBasic.class, 2); //  if not found then throw exception

        System.out.println(student);
        System.out.println(studentBasic);

        session.close();
        factory.close();
    }
}
