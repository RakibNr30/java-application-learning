package com.resume.repositories.ums.impls;

import com.resume.entities.ums.UserSocialAccount;
import com.resume.repositories.ums.UserSocialAccountRepository;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserSocialAccountRepositoryHibernateImpl implements UserSocialAccountRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserSocialAccountRepositoryHibernateImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<UserSocialAccount> findAll() {
        return this.hibernateTemplate.loadAll(UserSocialAccount.class);
    }

    @Override
    public <T> List<UserSocialAccount> findAllBy(String propertyName, T value) {
        DetachedCriteria criteria = DetachedCriteria
                .forEntityName(UserSocialAccount.class.getName())
                .add(Restrictions.eq(propertyName, value));

        return (List<UserSocialAccount>) this.hibernateTemplate.findByCriteria(criteria);
    }

    @Override
    @Transactional
    public void save(UserSocialAccount userSocialAccount) {
        this.hibernateTemplate.save(userSocialAccount);
    }

    @Override
    public UserSocialAccount findById(long id) {
        return this.hibernateTemplate.get(UserSocialAccount.class, id);
    }

    @Override
    @Transactional
    public void update(UserSocialAccount userSocialAccount) {
        this.hibernateTemplate.update(userSocialAccount);
    }

    @Override
    @Transactional
    public void delete(UserSocialAccount userSocialAccount) {
        this.hibernateTemplate.delete(userSocialAccount);
    }
}
