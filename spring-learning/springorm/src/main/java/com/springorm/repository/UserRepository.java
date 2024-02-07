package com.springorm.repository;

import com.springorm.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();

    int save(User user);

    User get(int id);

    void update(User user);

    void delete(int id);
}
