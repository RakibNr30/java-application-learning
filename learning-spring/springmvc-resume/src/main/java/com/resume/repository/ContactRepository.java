package com.resume.repository;

import com.resume.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ContactRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public ContactRepository(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public List<Contact> getAll() {
        return this.hibernateTemplate.loadAll(Contact.class);
    }

    public Contact get(long id) {
        return this.hibernateTemplate.get(Contact.class, id);
    }

    @Transactional
    public void save(Contact contact) {
        this.hibernateTemplate.save(contact);
    }

    @Transactional
    public void saveOrUpdate(Contact contact) {
        this.hibernateTemplate.saveOrUpdate(contact);
    }

    @Transactional
    public void update(Contact contact) {
        this.hibernateTemplate.update(contact);
    }

    @Transactional
    public void delete(Contact contact) {
        this.hibernateTemplate.delete(contact);
    }
}
