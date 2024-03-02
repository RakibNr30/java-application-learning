package com.resume.service.ums;

import com.resume.entity.ums.UserSocialAccount;
import com.resume.repository.ums.UserSocialAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSocialAccountService {

    private final UserSocialAccountRepository userSocialAccountRepository;

    @Autowired
    public UserSocialAccountService(UserSocialAccountRepository userSocialAccountRepository) {
        this.userSocialAccountRepository = userSocialAccountRepository;
    }

    public <T> List<UserSocialAccount> findAllBy(String propertyName, T value) {
        return null;
        //return this.userSocialAccountRepository.findAllBy(propertyName, value);
    }

    public List<UserSocialAccount> findAll() {
        return this.userSocialAccountRepository.findAll();
    }

    public UserSocialAccount save(UserSocialAccount userSocialAccount) {
        return this.userSocialAccountRepository.save(userSocialAccount);
    }

    public UserSocialAccount findById(Long id) {
        return this.userSocialAccountRepository.findById(id).orElse(null);
    }

    public UserSocialAccount update(UserSocialAccount userSocialAccount) {
        return this.userSocialAccountRepository.save(userSocialAccount);
    }

    public void delete(UserSocialAccount userSocialAccount) {
        this.userSocialAccountRepository.delete(userSocialAccount);
    }
}
