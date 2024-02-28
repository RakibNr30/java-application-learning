package com.resume.repositories.ums;

import com.resume.entities.ums.UserInterest;

import java.util.List;

public interface UserInterestRepository {

    List<UserInterest> findAll();

    <T> List<UserInterest> findAllBy(String propertyName, T value);

    void save(UserInterest userInterest);

    UserInterest findById(long id);

    void update(UserInterest userInterest);

    void delete(UserInterest userInterest);
}