package com.resume.repositories.ums;

import com.resume.entities.ums.UserAward;

import java.util.List;

public interface UserAwardRepository {

    List<UserAward> findAll();

    <T> List<UserAward> findAllBy(String propertyName, T value);

    void save(UserAward userAward);

    UserAward findById(long id);

    void update(UserAward userAward);

    void delete(UserAward userAward);
}