package com.resume.repositories.ums.impls;

import com.resume.entities.ums.UserExperience;
import com.resume.repositories.ums.UserExperienceRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserExperienceRepositoryHibernateImpl implements UserExperienceRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserExperienceRepositoryHibernateImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<UserExperience> findAll() {
        return this.hibernateTemplate.loadAll(UserExperience.class);
    }

    @Override
    public <T> List<UserExperience> findAllBy(String propertyName, T value) {
        DetachedCriteria criteria = DetachedCriteria
                .forEntityName(UserExperience.class.getName())
                .add(Restrictions.eq(propertyName, value));

        return (List<UserExperience>) this.hibernateTemplate.findByCriteria(criteria);
    }

    @Override
    @Transactional
    public void save(UserExperience userExperience) {
        this.hibernateTemplate.save(userExperience);
    }

    @Override
    public UserExperience findById(long id) {
        return this.hibernateTemplate.get(UserExperience.class, id);
    }

    @Override
    @Transactional
    public void update(UserExperience userExperience) {
        this.hibernateTemplate.update(userExperience);
    }

    @Override
    @Transactional
    public void delete(UserExperience userExperience) {
        this.hibernateTemplate.delete(userExperience);
    }
}
