package com.resume.repositories.ums.impls;

import com.resume.entities.ums.UserEducation;
import com.resume.repositories.ums.UserEducationRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserEducationRepositoryHibernateImpl implements UserEducationRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserEducationRepositoryHibernateImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<UserEducation> findAll() {
        return this.hibernateTemplate.loadAll(UserEducation.class);
    }

    @Override
    public <T> List<UserEducation> findAllBy(String propertyName, T value) {
        DetachedCriteria criteria = DetachedCriteria
                .forEntityName(UserEducation.class.getName())
                .add(Restrictions.eq(propertyName, value));

        return (List<UserEducation>) this.hibernateTemplate.findByCriteria(criteria);
    }

    @Override
    @Transactional
    public void save(UserEducation userEducation) {
        this.hibernateTemplate.save(userEducation);
    }

    @Override
    public UserEducation findById(long id) {
        return this.hibernateTemplate.get(UserEducation.class, id);
    }

    @Override
    @Transactional
    public void update(UserEducation userEducation) {
        this.hibernateTemplate.update(userEducation);
    }

    @Override
    @Transactional
    public void delete(UserEducation userEducation) {
        this.hibernateTemplate.delete(userEducation);
    }
}
