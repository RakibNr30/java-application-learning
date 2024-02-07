package com.hibernate;

import com.hibernate.entity.Student;
import com.hibernate.entity.StudentBasic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Project Started..." );

        SessionFactory factory = (new Configuration()).configure("hibernate.cfg.xml").buildSessionFactory();

        /* student */
        Student student = new Student();
        student.setName("Abdur Rakib");

        /* student basic */
        StudentBasic studentBasic = new StudentBasic();
        studentBasic.setStreet("Trishal");
        studentBasic.setCity("Mymensingh");
        studentBasic.setValue(1.05);

        FileInputStream fileInputStream = new FileInputStream("/media/rakib/Documents/PROJECT/JAVA/LEARNING/learning-java-application/learning-hibernate/hibernate/src/main/resources/img/sign.jpg");
        byte[] image = new byte[fileInputStream.available()];
        fileInputStream.read(image);
        studentBasic.setImage(image);

        Session session = factory.openSession();

        Transaction transaction = session.getTransaction();

        /* save student */
        try {
            transaction.begin();
            session.save(student);
            session.save(studentBasic);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println(e.getMessage());
        }

        session.close();
        factory.close();
    }
}
