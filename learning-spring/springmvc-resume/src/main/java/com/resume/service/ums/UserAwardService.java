package com.resume.service.ums;

import com.resume.entity.ums.UserAward;
import com.resume.repository.ums.UserAwardRepository;
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

    public List<UserAward> getAll() {
        return this.userAwardRepository.getAll();
    }

    public void save(UserAward userAward) {
        this.userAwardRepository.save(userAward);
    }

    public UserAward get(long id) {
        return this.userAwardRepository.get(id);
    }

    public void update(UserAward userAward) {
        this.userAwardRepository.update(userAward);
    }

    @Transactional
    public void delete(UserAward userAward) {
        this.userAwardRepository.delete(userAward);
    }
}
