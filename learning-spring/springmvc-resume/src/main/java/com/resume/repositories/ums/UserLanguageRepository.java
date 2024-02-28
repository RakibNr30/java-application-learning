package com.resume.repositories.ums;

import com.resume.entities.ums.UserLanguage;

import java.util.List;

public interface UserLanguageRepository {

    List<UserLanguage> findAll();

    <T> List<UserLanguage> findAllBy(String propertyName, T value);

    void save(UserLanguage userLanguage);

    UserLanguage findById(long id);

    void update(UserLanguage userLanguage);

    void delete(UserLanguage userLanguage);
}