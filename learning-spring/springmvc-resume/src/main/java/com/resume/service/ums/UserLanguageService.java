package com.resume.service.ums;

import com.resume.entity.ums.UserLanguage;
import com.resume.repository.ums.UserLanguageRepository;
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

    public List<UserLanguage> getAll() {
        return this.userLanguageRepository.getAll();
    }

    public <T> List<UserLanguage> getAllBy(String propertyName, T value) {
        return this.userLanguageRepository.getAllBy(propertyName, value);
    }

    public void save(UserLanguage userLanguage) {
        this.userLanguageRepository.save(userLanguage);
    }

    public UserLanguage get(long id) {
        return this.userLanguageRepository.get(id);
    }

    public void update(UserLanguage userLanguage) {
        this.userLanguageRepository.update(userLanguage);
    }

    @Transactional
    public void delete(UserLanguage userLanguage) {
        this.userLanguageRepository.delete(userLanguage);
    }
}
