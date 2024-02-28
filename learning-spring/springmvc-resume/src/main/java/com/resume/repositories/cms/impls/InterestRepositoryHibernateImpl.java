package com.resume.repositories.cms.impls;

import com.resume.entities.cms.Interest;
import com.resume.repositories.cms.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InterestRepositoryHibernateImpl implements InterestRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public InterestRepositoryHibernateImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<Interest> findAll() {
        return this.hibernateTemplate.loadAll(Interest.class);
    }

    @Override
    @Transactional
    public void save(Interest interest) {
        this.hibernateTemplate.save(interest);
    }

    @Override
    public Interest findById(long id) {
        return this.hibernateTemplate.get(Interest.class, id);
    }

    @Override
    @Transactional
    public void update(Interest interest) {
        this.hibernateTemplate.update(interest);
    }

    @Override
    @Transactional
    public void delete(Interest interest) {
        this.hibernateTemplate.delete(interest);
    }
}
