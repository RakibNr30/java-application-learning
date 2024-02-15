package com.resume.repository;

import com.resume.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SkillRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public SkillRepository(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public List<Skill> getAll() {
        return this.hibernateTemplate.loadAll(Skill.class);
    }

    @Transactional
    public void save(Skill skill) {
        this.hibernateTemplate.save(skill);
    }

    public Skill get(long id) {
        return this.hibernateTemplate.get(Skill.class, id);
    }

    @Transactional
    public void update(Skill skill) {
        this.hibernateTemplate.update(skill);
    }

    @Transactional
    public void delete(Skill skill) {
        this.hibernateTemplate.delete(skill);
    }
}
