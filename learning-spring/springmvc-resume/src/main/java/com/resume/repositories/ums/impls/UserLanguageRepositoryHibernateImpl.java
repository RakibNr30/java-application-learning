package com.resume.repositories.ums.impls;

import com.resume.entities.ums.UserLanguage;
import com.resume.repositories.ums.UserLanguageRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserLanguageRepositoryHibernateImpl implements UserLanguageRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserLanguageRepositoryHibernateImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<UserLanguage> findAll() {
        return this.hibernateTemplate.loadAll(UserLanguage.class);
    }

    @Override
    public <T> List<UserLanguage> findAllBy(String propertyName, T value) {
        DetachedCriteria criteria = DetachedCriteria
                .forEntityName(UserLanguage.class.getName())
                .add(Restrictions.eq(propertyName, value));

        return (List<UserLanguage>) this.hibernateTemplate.findByCriteria(criteria);
    }

    @Override
    @Transactional
    public void save(UserLanguage userLanguage) {
        this.hibernateTemplate.save(userLanguage);
    }

    @Override
    public UserLanguage findById(long id) {
        return this.hibernateTemplate.get(UserLanguage.class, id);
    }

    @Override
    @Transactional
    public void update(UserLanguage userLanguage) {
        this.hibernateTemplate.update(userLanguage);
    }

    @Override
    @Transactional
    public void delete(UserLanguage userLanguage) {
        this.hibernateTemplate.delete(userLanguage);
    }
}
