package com.resume.repositories.ums;

import com.resume.entities.ums.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    List<User> findAllByRoleName(String roleName);

    void save(User user);

    User findById(long id);

    User findByUsername(String username);

    void update(User user);

    void delete(User user);
}