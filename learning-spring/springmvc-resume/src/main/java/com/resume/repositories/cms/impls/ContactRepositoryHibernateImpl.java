package com.resume.repositories.cms.impls;

import com.resume.entities.cms.Contact;
import com.resume.repositories.cms.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ContactRepositoryHibernateImpl implements ContactRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public ContactRepositoryHibernateImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<Contact> findAll() {
        return this.hibernateTemplate.loadAll(Contact.class);
    }

    @Override
    public Contact findById(long id) {
        return this.hibernateTemplate.get(Contact.class, id);
    }

    @Override
    @Transactional
    public void save(Contact contact) {
        this.hibernateTemplate.save(contact);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Contact contact) {
        this.hibernateTemplate.saveOrUpdate(contact);
    }

    @Override
    @Transactional
    public void update(Contact contact) {
        this.hibernateTemplate.update(contact);
    }

    @Override
    @Transactional
    public void delete(Contact contact) {
        this.hibernateTemplate.delete(contact);
    }
}
