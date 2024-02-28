package com.resume.repositories.ums;

import com.resume.entities.ums.UserExperience;

import java.util.List;

public interface UserExperienceRepository {

    List<UserExperience> findAll();

    <T> List<UserExperience> findAllBy(String propertyName, T value);

    void save(UserExperience userExperience);

    UserExperience findById(long id);

    void update(UserExperience userExperience);

    void delete(UserExperience userExperience);
}