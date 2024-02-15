package com.resume.repository;

import com.resume.entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LanguageRepository {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Language> getAll() {
        return this.hibernateTemplate.loadAll(Language.class);
    }

    @Transactional
    public void save(Language language) {
        this.hibernateTemplate.save(language);
    }

    public Language get(long id) {
        return this.hibernateTemplate.get(Language.class, id);
    }

    @Transactional
    public void update(Language language) {
        this.hibernateTemplate.update(language);
    }

    @Transactional
    public void delete(Language language) {
        this.hibernateTemplate.delete(language);
    }
}
