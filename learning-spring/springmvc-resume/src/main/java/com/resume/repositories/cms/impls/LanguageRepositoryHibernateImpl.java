package com.resume.repositories.cms.impls;

import com.resume.entities.cms.Language;
import com.resume.repositories.cms.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LanguageRepositoryHibernateImpl implements LanguageRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public LanguageRepositoryHibernateImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<Language> findAll() {
        return this.hibernateTemplate.loadAll(Language.class);
    }

    @Override
    @Transactional
    public void save(Language language) {
        this.hibernateTemplate.save(language);
    }

    @Override
    public Language findById(long id) {
        return this.hibernateTemplate.get(Language.class, id);
    }

    @Override
    @Transactional
    public void update(Language language) {
        this.hibernateTemplate.update(language);
    }

    @Override
    @Transactional
    public void delete(Language language) {
        this.hibernateTemplate.delete(language);
    }
}
