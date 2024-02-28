package com.resume.repositories.ums.impls;

import com.resume.entities.ums.UserInterest;
import com.resume.repositories.ums.UserInterestRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserInterestRepositoryHibernateImpl implements UserInterestRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserInterestRepositoryHibernateImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<UserInterest> findAll() {
        return this.hibernateTemplate.loadAll(UserInterest.class);
    }

    @Override
    public <T> List<UserInterest> findAllBy(String propertyName, T value) {
        DetachedCriteria criteria = DetachedCriteria
                .forEntityName(UserInterest.class.getName())
                .add(Restrictions.eq(propertyName, value));

        return (List<UserInterest>) this.hibernateTemplate.findByCriteria(criteria);
    }

    @Override
    @Transactional
    public void save(UserInterest userInterest) {
        this.hibernateTemplate.save(userInterest);
    }

    @Override
    public UserInterest findById(long id) {
        return this.hibernateTemplate.get(UserInterest.class, id);
    }

    @Override
    @Transactional
    public void update(UserInterest userInterest) {
        this.hibernateTemplate.update(userInterest);
    }

    @Override
    @Transactional
    public void delete(UserInterest userInterest) {
        this.hibernateTemplate.delete(userInterest);
    }
}
