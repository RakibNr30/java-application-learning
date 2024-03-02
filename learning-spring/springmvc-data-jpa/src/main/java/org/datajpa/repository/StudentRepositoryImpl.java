/*
package org.datajpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.datajpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    */
/*@PersistenceContext(unitName = "postgresqldb")*//*

    private final EntityManager entityManager;

    @Autowired
    public StudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional
    @Override
    public void save(Student student) {
        try {
            entityManager.persist(student);
            System.out.println("Successfully Saved");
        } catch (Exception e) {
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }
}
*/
