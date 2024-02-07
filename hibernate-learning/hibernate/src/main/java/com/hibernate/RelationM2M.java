package com.hibernate;

import com.hibernate.entity.relation.m2m.Employee;
import com.hibernate.entity.relation.m2m.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RelationM2M {
    public static void main(String[] args) {
        SessionFactory factory = (new Configuration().configure("hibernate.cfg.xml")).buildSessionFactory();

        Employee employee1  = new Employee();
        Employee employee2  = new Employee();

        employee1.setName("Employee 01");
        employee2.setName("Employee 02");

        Project project1    = new Project();
        Project project2    = new Project();

        project1.setName("Project 01");
        project2.setName("Project 02");

        List<Employee> employees    = new ArrayList<>();
        List<Project> projects      = new ArrayList<>();

        employees.add(employee1);
        employees.add(employee2);

        projects.add(project1);
        projects.add(project2);

        employee1.setProjects(projects);
        project2.setEmployees(employees);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        try {

            session.save(employee1);
            session.save(employee2);
            session.save(project1);
            session.save(project2);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            System.err.println(e.getMessage());
        }

        session.close();
        factory.close();
    }
}
