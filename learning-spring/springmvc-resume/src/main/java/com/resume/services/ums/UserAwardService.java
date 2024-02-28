package com.resume.services.ums;

import com.resume.entities.ums.UserAward;
import com.resume.repositories.ums.UserAwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserAwardService {

    private final UserAwardRepository userAwardRepository;

    @Autowired
    public UserAwardService(UserAwardRepository userAwardRepository) {
        this.userAwardRepository = userAwardRepository;
    }

    public List<UserAward> findAll() {
        return this.userAwardRepository.findAll();
    }

    public <T> List<UserAward> findAllBy(String propertyName, T value) {
        return this.userAwardRepository.findAllBy(propertyName, value);
    }

    public void save(UserAward userAward) {
        this.userAwardRepository.save(userAward);
    }

    public UserAward findById(long id) {
        return this.userAwardRepository.findById(id);
    }

    public void update(UserAward userAward) {
        this.userAwardRepository.update(userAward);
    }

    @Transactional
    public void delete(UserAward userAward) {
        this.userAwardRepository.delete(userAward);
    }
}
