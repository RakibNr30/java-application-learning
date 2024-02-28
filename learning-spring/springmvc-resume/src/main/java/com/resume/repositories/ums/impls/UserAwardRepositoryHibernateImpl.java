package com.resume.repositories.ums.impls;

import com.resume.entities.ums.UserAward;
import com.resume.repositories.ums.UserAwardRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserAwardRepositoryHibernateImpl implements UserAwardRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserAwardRepositoryHibernateImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<UserAward> findAll() {
        return this.hibernateTemplate.loadAll(UserAward.class);
    }

    @Override
    public <T> List<UserAward> findAllBy(String propertyName, T value) {
        DetachedCriteria criteria = DetachedCriteria
                .forEntityName(UserAward.class.getName())
                .add(Restrictions.eq(propertyName, value));

        return (List<UserAward>) this.hibernateTemplate.findByCriteria(criteria);
    }

    @Override
    @Transactional
    public void save(UserAward userAward) {
        this.hibernateTemplate.save(userAward);
    }

    @Override
    public UserAward findById(long id) {
        return this.hibernateTemplate.get(UserAward.class, id);
    }

    @Override
    @Transactional
    public void update(UserAward userAward) {
        this.hibernateTemplate.update(userAward);
    }

    @Override
    @Transactional
    public void delete(UserAward userAward) {
        this.hibernateTemplate.delete(userAward);
    }
}
