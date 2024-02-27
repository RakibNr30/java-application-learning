package com.resume.repositories.ums;

import com.resume.entities.ums.UserAward;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserAwardRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserAwardRepository(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public List<UserAward> getAll() {
        return this.hibernateTemplate.loadAll(UserAward.class);
    }

    public <T> List<UserAward> getAllBy(String propertyName, T value) {
        DetachedCriteria criteria = DetachedCriteria
                .forEntityName(UserAward.class.getName())
                .add(Restrictions.eq(propertyName, value));

        return (List<UserAward>) this.hibernateTemplate.findByCriteria(criteria);
    }

    @Transactional
    public void save(UserAward userAward) {
        this.hibernateTemplate.save(userAward);
    }

    public UserAward get(long id) {
        return this.hibernateTemplate.get(UserAward.class, id);
    }

    @Transactional
    public void update(UserAward userAward) {
        this.hibernateTemplate.update(userAward);
    }

    @Transactional
    public void delete(UserAward userAward) {
        this.hibernateTemplate.delete(userAward);
    }
}
