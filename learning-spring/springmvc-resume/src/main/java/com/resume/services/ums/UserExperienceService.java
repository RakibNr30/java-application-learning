package com.resume.services.ums;

import com.resume.entities.ums.UserExperience;
import com.resume.repositories.ums.UserExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserExperienceService {

    private final UserExperienceRepository userExperienceRepository;

    @Autowired
    public UserExperienceService(UserExperienceRepository userExperienceRepository) {
        this.userExperienceRepository = userExperienceRepository;
    }

    public List<UserExperience> findAll() {
        return this.userExperienceRepository.findAll();
    }

    public <T> List<UserExperience> findAllBy(String propertyName, T value) {
        return this.userExperienceRepository.findAllBy(propertyName, value);
    }

    public void save(UserExperience userExperience) {
        this.userExperienceRepository.save(userExperience);
    }

    public UserExperience findById(long id) {
        return this.userExperienceRepository.findById(id);
    }

    public void update(UserExperience userExperience) {
        this.userExperienceRepository.update(userExperience);
    }

    @Transactional
    public void delete(UserExperience userExperience) {
        this.userExperienceRepository.delete(userExperience);
    }
}
