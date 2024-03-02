package com.resume.service.cms;

import com.resume.entity.cms.Skill;
import com.resume.repository.cms.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> findAll() {
        return this.skillRepository.findAll();
    }

    public Skill save(Skill skill) {
        return this.skillRepository.save(skill);
    }

    public Skill findById(Long id) {
        return this.skillRepository.findById(id).orElse(null);
    }

    public Skill update(Skill skill) {
        return this.skillRepository.save(skill);
    }

    public void delete(Skill skill) {
        this.skillRepository.delete(skill);
    }
}
