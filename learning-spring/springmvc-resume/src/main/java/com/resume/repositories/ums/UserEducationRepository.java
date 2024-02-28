package com.resume.repositories.ums;

import com.resume.entities.ums.UserEducation;

import java.util.List;

public interface UserEducationRepository {

    List<UserEducation> findAll();

    <T> List<UserEducation> findAllBy(String propertyName, T value);

    void save(UserEducation userEducation);

    UserEducation findById(long id);

    void update(UserEducation userEducation);

    void delete(UserEducation userEducation);
}