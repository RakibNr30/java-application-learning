package com.resume.service.ums;

import com.resume.entity.ums.UserSkill;
import com.resume.repository.ums.UserSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSkillService {

    private final UserSkillRepository userSkillRepository;

    @Autowired
    public UserSkillService(UserSkillRepository userSkillRepository) {
        this.userSkillRepository = userSkillRepository;
    }

    public List<UserSkill> findAll() {
        return this.userSkillRepository.findAll();
    }

    public <T> List<UserSkill> findAllBy(String propertyName, T value) {
        return null;
        //return this.userSkillRepository.findAllBy(propertyName, value);
    }

    public UserSkill save(UserSkill userSkill) {
        return this.userSkillRepository.save(userSkill);
    }

    public UserSkill findById(Long id) {
        return this.userSkillRepository.findById(id).orElse(null);
    }

    public UserSkill update(UserSkill userSkill) {
        return this.userSkillRepository.save(userSkill);
    }

    public void delete(UserSkill userSkill) {
        this.userSkillRepository.delete(userSkill);
    }
}
