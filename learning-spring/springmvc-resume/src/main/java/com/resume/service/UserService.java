package com.resume.service;

import com.resume.entity.User;
import com.resume.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

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
