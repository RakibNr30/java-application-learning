package com.resume.repositories.cms;

import com.resume.entities.cms.Interest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InterestRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public InterestRepository(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public List<Interest> getAll() {
        return this.hibernateTemplate.loadAll(Interest.class);
    }

    @Transactional
    public void save(Interest interest) {
        this.hibernateTemplate.save(interest);
    }

    public Interest get(long id) {
        return this.hibernateTemplate.get(Interest.class, id);
    }

    @Transactional
    public void update(Interest interest) {
        this.hibernateTemplate.update(interest);
    }

    @Transactional
    public void delete(Interest interest) {
        this.hibernateTemplate.delete(interest);
    }
}
