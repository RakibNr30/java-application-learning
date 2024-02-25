package com.resume.service.ums;

import com.resume.entity.ums.UserInterest;
import com.resume.repository.ums.UserInterestRepository;
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

    public List<UserInterest> getAll() {
        return this.userInterestRepository.getAll();
    }

    public void save(UserInterest userInterest) {
        this.userInterestRepository.save(userInterest);
    }

    public UserInterest get(long id) {
        return this.userInterestRepository.get(id);
    }

    public void update(UserInterest userInterest) {
        this.userInterestRepository.update(userInterest);
    }

    @Transactional
    public void delete(UserInterest userInterest) {
        this.userInterestRepository.delete(userInterest);
    }
}
