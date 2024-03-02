package com.resume.service.ums;

import com.resume.entity.ums.UserEducation;
import com.resume.repository.ums.UserEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
        //return this.userEducationRepository.findAllBy(propertyName, value);
    }

    public UserEducation save(UserEducation userEducation) {
        return this.userEducationRepository.save(userEducation);
    }

    public UserEducation findById(Long id) {
        return this.userEducationRepository.findById(id).orElse(null);
    }

    public UserEducation update(UserEducation userEducation) {
        return this.userEducationRepository.save(userEducation);
    }

    public void delete(UserEducation userEducation) {
        this.userEducationRepository.delete(userEducation);
    }
}
