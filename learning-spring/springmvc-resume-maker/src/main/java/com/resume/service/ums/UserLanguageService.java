package com.resume.service.ums;

import com.resume.entity.ums.UserLanguage;
import com.resume.repository.ums.UserLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
        //return this.userLanguageRepository.findAllBy(propertyName, value);
    }

    public UserLanguage save(UserLanguage userLanguage) {
        return this.userLanguageRepository.save(userLanguage);
    }

    public UserLanguage findById(Long id) {
        return this.userLanguageRepository.findById(id).orElse(null);
    }

    public UserLanguage update(UserLanguage userLanguage) {
        return this.userLanguageRepository.save(userLanguage);
    }

    public void delete(UserLanguage userLanguage) {
        this.userLanguageRepository.delete(userLanguage);
    }
}
