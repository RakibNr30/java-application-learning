package com.resume.repositories.cms;

import com.resume.entities.cms.SocialAccount;

import java.util.List;

public interface SocialAccountRepository {

    List<SocialAccount> findAll();

    void save(SocialAccount socialAccount);

    SocialAccount findById(long id);

    void update(SocialAccount socialAccount);

    void delete(SocialAccount socialAccount);
}
