package com.resume.services.ums;

import com.resume.entities.ums.UserEducation;
import com.resume.repositories.ums.UserEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserEducationService {

    private final UserEducationRepository userEducationRepository;

    @Autowired
    public UserEducationService(UserEducationRepository userEducationRepository) {
        this.userEducationRepository = userEducationRepository;
    }

    public List<UserEducation> findAll() {
        return this.userEducationRepository.findAll();
    }

    public <T> List<UserEducation> findAllBy(String propertyName, T value) {
        return this.userEducationRepository.findAllBy(propertyName, value);
    }

    public void save(UserEducation userEducation) {
        this.userEducationRepository.save(userEducation);
    }

    public UserEducation findById(long id) {
        return this.userEducationRepository.findById(id);
    }

    public void update(UserEducation userEducation) {
        this.userEducationRepository.update(userEducation);
    }

    @Transactional
    public void delete(UserEducation userEducation) {
        this.userEducationRepository.delete(userEducation);
    }
}
