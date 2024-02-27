package com.resume.repositories.ums;

import com.resume.entities.ums.UserInterest;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserInterestRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserInterestRepository(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public List<UserInterest> getAll() {
        return this.hibernateTemplate.loadAll(UserInterest.class);
    }

    public <T> List<UserInterest> getAllBy(String propertyName, T value) {
        DetachedCriteria criteria = DetachedCriteria
                .forEntityName(UserInterest.class.getName())
                .add(Restrictions.eq(propertyName, value));

        return (List<UserInterest>) this.hibernateTemplate.findByCriteria(criteria);
    }

    @Transactional
    public void save(UserInterest userInterest) {
        this.hibernateTemplate.save(userInterest);
    }

    public UserInterest get(long id) {
        return this.hibernateTemplate.get(UserInterest.class, id);
    }

    @Transactional
    public void update(UserInterest userInterest) {
        this.hibernateTemplate.update(userInterest);
    }

    @Transactional
    public void delete(UserInterest userInterest) {
        this.hibernateTemplate.delete(userInterest);
    }
}
