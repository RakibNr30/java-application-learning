package com.resume.service.ums;

import com.resume.entity.ums.UserSocialAccount;
import com.resume.repository.ums.UserSocialAccountRepository;
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

    public <T> List<UserSocialAccount> getAllBy(String propertyName, T value) {
        return this.userSocialAccountRepository.getAllBy(propertyName, value);
    }

    public List<UserSocialAccount> getAll() {
        return this.userSocialAccountRepository.getAll();
    }

    public void save(UserSocialAccount userSocialAccount) {
        this.userSocialAccountRepository.save(userSocialAccount);
    }

    public UserSocialAccount get(long id) {
        return this.userSocialAccountRepository.get(id);
    }

    public void update(UserSocialAccount userSocialAccount) {
        this.userSocialAccountRepository.update(userSocialAccount);
    }

    @Transactional
    public void delete(UserSocialAccount userSocialAccount) {
        this.userSocialAccountRepository.delete(userSocialAccount);
    }
}
