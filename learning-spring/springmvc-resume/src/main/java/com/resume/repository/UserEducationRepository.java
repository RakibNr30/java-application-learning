package com.resume.repository;

import com.resume.entity.UserEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserEducationRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserEducationRepository(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public List<UserEducation> getAll() {
        return this.hibernateTemplate.loadAll(UserEducation.class);
    }

    @Transactional
    public void save(UserEducation userEducation) {
        this.hibernateTemplate.save(userEducation);
    }

    public UserEducation get(long id) {
        return this.hibernateTemplate.get(UserEducation.class, id);
    }

    @Transactional
    public void update(UserEducation userEducation) {
        this.hibernateTemplate.update(userEducation);
    }

    @Transactional
    public void delete(UserEducation userEducation) {
        this.hibernateTemplate.delete(userEducation);
    }
}
