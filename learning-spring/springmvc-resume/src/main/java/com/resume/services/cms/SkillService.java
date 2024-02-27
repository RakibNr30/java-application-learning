package com.resume.services.cms;

import com.resume.entities.cms.Skill;
import com.resume.repositories.cms.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAll() {
        return this.skillRepository.getAll();
    }

    public void save(Skill skill) {
        this.skillRepository.save(skill);
    }

    public Skill get(long id) {
        return this.skillRepository.get(id);
    }

    public void update(Skill skill) {
        this.skillRepository.update(skill);
    }

    @Transactional
    public void delete(Skill skill) {
        this.skillRepository.delete(skill);
    }
}
