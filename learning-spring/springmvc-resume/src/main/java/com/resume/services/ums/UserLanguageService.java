package com.resume.services.ums;

import com.resume.entities.ums.UserLanguage;
import com.resume.repositories.ums.UserLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserLanguageService {

    private final UserLanguageRepository userLanguageRepository;

    @Autowired
    public UserLanguageService(UserLanguageRepository userLanguageRepository) {
        this.userLanguageRepository = userLanguageRepository;
    }

    public List<UserLanguage> findAll() {
        return this.userLanguageRepository.findAll();
    }

    public <T> List<UserLanguage> findAllBy(String propertyName, T value) {
        return this.userLanguageRepository.findAllBy(propertyName, value);
    }

    public void save(UserLanguage userLanguage) {
        this.userLanguageRepository.save(userLanguage);
    }

    public UserLanguage findById(long id) {
        return this.userLanguageRepository.findById(id);
    }

    public void update(UserLanguage userLanguage) {
        this.userLanguageRepository.update(userLanguage);
    }

    @Transactional
    public void delete(UserLanguage userLanguage) {
        this.userLanguageRepository.delete(userLanguage);
    }
}
