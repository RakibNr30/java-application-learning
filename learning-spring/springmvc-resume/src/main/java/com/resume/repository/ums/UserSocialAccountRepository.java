package com.resume.repository.ums;

import com.resume.entity.ums.UserSocialAccount;
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
