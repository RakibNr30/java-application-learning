package com.resume.services.ums;

import com.resume.entities.ums.UserInterest;
import com.resume.repositories.ums.UserInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserInterestService {

    private final UserInterestRepository userInterestRepository;

    @Autowired
    public UserInterestService(UserInterestRepository userInterestRepository) {
        this.userInterestRepository = userInterestRepository;
    }

    public List<UserInterest> findAll() {
        return this.userInterestRepository.findAll();
    }

    public <T> List<UserInterest> findAllBy(String propertyName, T value) {
        return this.userInterestRepository.findAllBy(propertyName, value);
    }

    public void save(UserInterest userInterest) {
        this.userInterestRepository.save(userInterest);
    }

    public UserInterest findById(long id) {
        return this.userInterestRepository.findById(id);
    }

    public void update(UserInterest userInterest) {
        this.userInterestRepository.update(userInterest);
    }

    @Transactional
    public void delete(UserInterest userInterest) {
        this.userInterestRepository.delete(userInterest);
    }
}
