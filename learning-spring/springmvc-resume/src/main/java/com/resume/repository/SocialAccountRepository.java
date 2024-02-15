package com.resume.repository;

import com.resume.entity.SocialAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SocialAccountRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public SocialAccountRepository(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public List<SocialAccount> getAll() {
        return this.hibernateTemplate.loadAll(SocialAccount.class);
    }

    @Transactional
    public void save(SocialAccount socialAccount) {
        this.hibernateTemplate.save(socialAccount);
    }

    public SocialAccount get(long id) {
        return this.hibernateTemplate.get(SocialAccount.class, id);
    }

    @Transactional
    public void update(SocialAccount socialAccount) {
        this.hibernateTemplate.update(socialAccount);
    }

    @Transactional
    public void delete(SocialAccount socialAccount) {
        this.hibernateTemplate.delete(socialAccount);
    }
}
