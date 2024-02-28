package com.resume.repositories.cms.impls;

import com.resume.entities.cms.SocialAccount;
import com.resume.repositories.cms.SocialAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SocialAccountRepositoryHibernateImpl implements SocialAccountRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public SocialAccountRepositoryHibernateImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<SocialAccount> findAll() {
        return this.hibernateTemplate.loadAll(SocialAccount.class);
    }

    @Override
    @Transactional
    public void save(SocialAccount socialAccount) {
        this.hibernateTemplate.save(socialAccount);
    }

    @Override
    public SocialAccount findById(long id) {
        return this.hibernateTemplate.get(SocialAccount.class, id);
    }

    @Override
    @Transactional
    public void update(SocialAccount socialAccount) {
        this.hibernateTemplate.update(socialAccount);
    }

    @Override
    @Transactional
    public void delete(SocialAccount socialAccount) {
        this.hibernateTemplate.delete(socialAccount);
    }
}
