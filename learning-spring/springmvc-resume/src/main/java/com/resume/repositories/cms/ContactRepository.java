package com.resume.repositories.cms;

import com.resume.entities.cms.Contact;

import java.util.List;

public interface ContactRepository {

    List<Contact> findAll();

    Contact findById(long id);

    void save(Contact contact);

    void saveOrUpdate(Contact contact);

    void update(Contact contact);

    void delete(Contact contact);
}
