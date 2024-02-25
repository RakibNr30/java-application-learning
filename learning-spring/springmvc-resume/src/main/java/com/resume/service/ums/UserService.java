package com.resume.service.ums;

import com.resume.entity.ums.User;
import com.resume.repository.ums.UserRepository;
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

    public List<User> getAll() {
        return this.userRepository.getAll();
    }

    public List<User> getAllByRoleName(String roleName) {
        return this.userRepository.getAllByRoleName(roleName);
    }

    public void save(User user) {
        this.userRepository.save(user);
    }

    public User get(long id) {
        return this.userRepository.get(id);
    }

    public User getByUsername(String username) {
        return this.userRepository.getByUsername(username);
    }

    public void update(User user) {
        this.userRepository.update(user);
    }

    @Transactional
    public void delete(User user) {
        this.userRepository.delete(user);
    }
}
