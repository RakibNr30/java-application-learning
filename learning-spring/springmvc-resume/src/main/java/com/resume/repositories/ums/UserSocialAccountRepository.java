package com.resume.repositories.ums;

import com.resume.entities.ums.UserSocialAccount;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserSocialAccountRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserSocialAccountRepository(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public List<UserSocialAccount> getAll() {
        return this.hibernateTemplate.loadAll(UserSocialAccount.class);
    }

    public <T> List<UserSocialAccount> getAllBy(String propertyName, T value) {
        DetachedCriteria criteria = DetachedCriteria
                .forEntityName(UserSocialAccount.class.getName())
                .add(Restrictions.eq(propertyName, value));

        return (List<UserSocialAccount>) this.hibernateTemplate.findByCriteria(criteria);
    }

    @Transactional
    public void save(UserSocialAccount userSocialAccount) {
        this.hibernateTemplate.save(userSocialAccount);
    }

    public UserSocialAccount get(long id) {
        return this.hibernateTemplate.get(UserSocialAccount.class, id);
    }

    @Transactional
    public void update(UserSocialAccount userSocialAccount) {
        this.hibernateTemplate.update(userSocialAccount);
    }

    @Transactional
    public void delete(UserSocialAccount userSocialAccount) {
        this.hibernateTemplate.delete(userSocialAccount);
    }
}
