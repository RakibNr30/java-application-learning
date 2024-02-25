package com.resume.repository.ums;

import com.resume.entity.ums.UserLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserLanguageRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserLanguageRepository(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public List<UserLanguage> getAll() {
        return this.hibernateTemplate.loadAll(UserLanguage.class);
    }

    @Transactional
    public void save(UserLanguage userLanguage) {
        this.hibernateTemplate.save(userLanguage);
    }

    public UserLanguage get(long id) {
        return this.hibernateTemplate.get(UserLanguage.class, id);
    }

    @Transactional
    public void update(UserLanguage userLanguage) {
        this.hibernateTemplate.update(userLanguage);
    }

    @Transactional
    public void delete(UserLanguage userLanguage) {
        this.hibernateTemplate.delete(userLanguage);
    }
}
