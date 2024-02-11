package com.resume.service;

import com.resume.entity.Skill;
import com.resume.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

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
