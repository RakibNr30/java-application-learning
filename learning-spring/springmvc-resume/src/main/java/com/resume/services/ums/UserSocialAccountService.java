package com.resume.services.ums;

import com.resume.entities.ums.UserSocialAccount;
import com.resume.repositories.ums.UserSocialAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserSocialAccountService {

    private final UserSocialAccountRepository userSocialAccountRepository;

    @Autowired
    public UserSocialAccountService(UserSocialAccountRepository userSocialAccountRepository) {
        this.userSocialAccountRepository = userSocialAccountRepository;
    }

    public <T> List<UserSocialAccount> findAllBy(String propertyName, T value) {
        return this.userSocialAccountRepository.findAllBy(propertyName, value);
    }

    public List<UserSocialAccount> findAll() {
        return this.userSocialAccountRepository.findAll();
    }

    public void save(UserSocialAccount userSocialAccount) {
        this.userSocialAccountRepository.save(userSocialAccount);
    }

    public UserSocialAccount findById(long id) {
        return this.userSocialAccountRepository.findById(id);
    }

    public void update(UserSocialAccount userSocialAccount) {
        this.userSocialAccountRepository.update(userSocialAccount);
    }

    @Transactional
    public void delete(UserSocialAccount userSocialAccount) {
        this.userSocialAccountRepository.delete(userSocialAccount);
    }
}
