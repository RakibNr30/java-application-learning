package com.resume.repositories.cms.impls;

import com.resume.entities.cms.Skill;
import com.resume.repositories.cms.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SkillRepositoryHibernateImpl implements SkillRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public SkillRepositoryHibernateImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<Skill> findAll() {
        return this.hibernateTemplate.loadAll(Skill.class);
    }

    @Override
    @Transactional
    public void save(Skill skill) {
        this.hibernateTemplate.save(skill);
    }

    @Override
    public Skill findById(long id) {
        return this.hibernateTemplate.get(Skill.class, id);
    }

    @Override
    @Transactional
    public void update(Skill skill) {
        this.hibernateTemplate.update(skill);
    }

    @Override
    @Transactional
    public void delete(Skill skill) {
        this.hibernateTemplate.delete(skill);
    }
}
