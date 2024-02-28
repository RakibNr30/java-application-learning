package com.resume.services.ums;

import com.resume.entities.ums.User;
import com.resume.repositories.ums.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public List<User> findAllByRoleName(String roleName) {
        return this.userRepository.findAllByRoleName(roleName);
    }

    public void save(User user) {
        this.userRepository.save(user);
    }

    public User findById(long id) {
        return this.userRepository.findById(id);
    }

    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    public void update(User user) {
        this.userRepository.update(user);
    }

    @Transactional
    public void delete(User user) {
        this.userRepository.delete(user);
    }
}
