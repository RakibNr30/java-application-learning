package com.resume.repositories.ums;

import com.resume.entities.ums.UserSocialAccount;

import java.util.List;

public interface UserSocialAccountRepository {

    List<UserSocialAccount> findAll();

    <T> List<UserSocialAccount> findAllBy(String propertyName, T value);

    void save(UserSocialAccount userSocialAccount);

    UserSocialAccount findById(long id);

    void update(UserSocialAccount userSocialAccount);

    void delete(UserSocialAccount userSocialAccount);
}