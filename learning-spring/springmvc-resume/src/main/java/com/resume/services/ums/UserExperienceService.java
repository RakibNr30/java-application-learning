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

    public List<UserExperience> getAll() {
        return this.userExperienceRepository.getAll();
    }

    public <T> List<UserExperience> getAllBy(String propertyName, T value) {
        return this.userExperienceRepository.getAllBy(propertyName, value);
    }

    public void save(UserExperience userExperience) {
        this.userExperienceRepository.save(userExperience);
    }

    public UserExperience get(long id) {
        return this.userExperienceRepository.get(id);
    }

    public void update(UserExperience userExperience) {
        this.userExperienceRepository.update(userExperience);
    }

    @Transactional
    public void delete(UserExperience userExperience) {
        this.userExperienceRepository.delete(userExperience);
    }
}
