package com.resume.repositories.cms;

import com.resume.entities.cms.Interest;

import java.util.List;

public interface InterestRepository {

    List<Interest> findAll();

    void save(Interest interest);

    Interest findById(long id);

    void update(Interest interest);

    void delete(Interest interest);
}
