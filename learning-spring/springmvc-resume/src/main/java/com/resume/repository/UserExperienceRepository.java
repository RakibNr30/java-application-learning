package com.resume.repository;

import com.resume.entity.UserExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserExperienceRepository {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<UserExperience> getAll() {
        return this.hibernateTemplate.loadAll(UserExperience.class);
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
