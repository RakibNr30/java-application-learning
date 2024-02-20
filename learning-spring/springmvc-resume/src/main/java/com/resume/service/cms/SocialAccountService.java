package com.resume.service.cms;

import com.resume.entity.cms.SocialAccount;
import com.resume.repository.cms.SocialAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SocialAccountService {

    private final SocialAccountRepository socialAccountRepository;

    @Autowired
    public SocialAccountService(SocialAccountRepository socialAccountRepository) {
        this.socialAccountRepository = socialAccountRepository;
    }

    public List<SocialAccount> getAll() {
        return this.socialAccountRepository.getAll();
    }

    public void save(SocialAccount socialAccount) {
        this.socialAccountRepository.save(socialAccount);
    }

    public SocialAccount get(long id) {
        return this.socialAccountRepository.get(id);
    }

    public void update(SocialAccount socialAccount) {
        this.socialAccountRepository.update(socialAccount);
    }

    @Transactional
    public void delete(SocialAccount socialAccount) {
        this.socialAccountRepository.delete(socialAccount);
    }
}
