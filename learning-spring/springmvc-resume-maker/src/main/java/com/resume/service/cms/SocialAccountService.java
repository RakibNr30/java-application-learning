package com.resume.service.cms;

import com.resume.entity.cms.SocialAccount;
import com.resume.repository.cms.SocialAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialAccountService {

    private final SocialAccountRepository socialAccountRepository;

    @Autowired
    public SocialAccountService(SocialAccountRepository socialAccountRepository) {
        this.socialAccountRepository = socialAccountRepository;
    }

    public List<SocialAccount> findAll() {
        return this.socialAccountRepository.findAll();
    }

    public SocialAccount save(SocialAccount socialAccount) {
        return this.socialAccountRepository.save(socialAccount);
    }

    public SocialAccount findById(Long id) {
        return this.socialAccountRepository.findById(id).orElse(null);
    }

    public SocialAccount update(SocialAccount socialAccount) {
        return this.socialAccountRepository.save(socialAccount);
    }

    public void delete(SocialAccount socialAccount) {
        this.socialAccountRepository.delete(socialAccount);
    }
}
