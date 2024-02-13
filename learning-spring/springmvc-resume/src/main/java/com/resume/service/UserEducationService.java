package com.resume.service;

import com.resume.entity.UserEducation;
import com.resume.repository.UserEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserEducationService {

    @Autowired
    private UserEducationRepository userEducationRepository;

    public List<UserEducation> getAll() {
        return this.userEducationRepository.getAll();
    }

    public void save(UserEducation userEducation) {
        this.userEducationRepository.save(userEducation);
    }

    public UserEducation get(long id) {
        return this.userEducationRepository.get(id);
    }

    public void update(UserEducation userEducation) {
        this.userEducationRepository.update(userEducation);
    }

    @Transactional
    public void delete(UserEducation userEducation) {
        this.userEducationRepository.delete(userEducation);
    }
}
