package com.resume.service.ums;

import com.resume.entity.ums.UserInterest;
import com.resume.repository.ums.UserInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
        //return this.userInterestRepository.findAllBy(propertyName, value);
    }

    public UserInterest save(UserInterest userInterest) {
        return this.userInterestRepository.save(userInterest);
    }

    public UserInterest findById(Long id) {
        return this.userInterestRepository.findById(id).orElse(null);
    }

    public UserInterest update(UserInterest userInterest) {
        return this.userInterestRepository.save(userInterest);
    }

    public void delete(UserInterest userInterest) {
        this.userInterestRepository.delete(userInterest);
    }
}
