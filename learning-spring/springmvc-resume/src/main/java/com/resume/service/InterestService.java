package com.resume.service;

import com.resume.entity.Interest;
import com.resume.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InterestService {

    @Autowired
    private InterestRepository interestRepository;

    public List<Interest> getAll() {
        return this.interestRepository.getAll();
    }

    public void save(Interest interest) {
        this.interestRepository.save(interest);
    }

    public Interest get(long id) {
        return this.interestRepository.get(id);
    }

    public void update(Interest interest) {
        this.interestRepository.update(interest);
    }

    @Transactional
    public void delete(Interest interest) {
        this.interestRepository.delete(interest);
    }
}
