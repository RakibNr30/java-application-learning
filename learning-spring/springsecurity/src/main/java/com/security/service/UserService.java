package com.security.service;

import com.security.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(1L, "user1", "user1", "user1@example.com"));
        users.add(new User(2L, "user2", "user2", "user2@example.com"));
        users.add(new User(3L, "user3", "user3", "user3@example.com"));
        users.add(new User(4L, "user4", "user4", "user4@example.com"));
    }

    /* get all user */
    public List<User> getAll() {
        return this.users;
    }

    /* add user */
    public void add(User user) {
        this.users.add(user);
    }

    /* get single user */
    public User get(String username) {
        return this.users
                .stream()
                .filter(user -> user.getUsername().equals(username))
                .findAny()
                .orElse(null);
    }
}
