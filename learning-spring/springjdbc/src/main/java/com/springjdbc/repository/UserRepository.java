package com.springjdbc.repository;

import com.springjdbc.entity.User;

import java.util.List;

public interface UserRepository {
    int insert(User user);

    int update(User user);

    int delete(int id);

    User get(int id);

    List<User> getAll();
}
