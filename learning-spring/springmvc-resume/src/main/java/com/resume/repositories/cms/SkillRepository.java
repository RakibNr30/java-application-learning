package com.resume.repositories.cms;

import com.resume.entities.cms.Skill;

import java.util.List;

public interface SkillRepository {

    List<Skill> findAll();

    void save(Skill skill);

    Skill findById(long id);

    void update(Skill skill);

    void delete(Skill skill);
}
