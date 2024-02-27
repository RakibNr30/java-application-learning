package com.resume.repositories.ums;

import com.resume.entities.ums.UserExperience;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserExperienceRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserExperienceRepository(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public List<UserExperience> getAll() {
        return this.hibernateTemplate.loadAll(UserExperience.class);
    }

    public <T> List<UserExperience> getAllBy(String propertyName, T value) {
        DetachedCriteria criteria = DetachedCriteria
                .forEntityName(UserExperience.class.getName())
                .add(Restrictions.eq(propertyName, value));

        return (List<UserExperience>) this.hibernateTemplate.findByCriteria(criteria);
    }

    @Transactional
    public void save(UserExperience userExperience) {
        this.hibernateTemplate.save(userExperience);
    }

    public UserExperience get(long id) {
        return this.hibernateTemplate.get(UserExperience.class, id);
    }

    @Transactional
    public void update(UserExperience userExperience) {
        this.hibernateTemplate.update(userExperience);
    }

    @Transactional
    public void delete(UserExperience userExperience) {
        this.hibernateTemplate.delete(userExperience);
    }
}
