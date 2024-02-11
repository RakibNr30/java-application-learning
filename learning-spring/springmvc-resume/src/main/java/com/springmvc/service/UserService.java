package com.springmvc.service;

import com.springmvc.entity.User;
import com.springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return this.userRepository.getAll();
    }

    public void save(User user) {
        this.userRepository.save(user);
    }

    public User get(long id) {
        return this.userRepository.get(id);
    }

    public void update(User user) {
        this.userRepository.update(user);
    }

    @Transactional
    public void delete(User user) {
        this.userRepository.delete(user);
    }
}
