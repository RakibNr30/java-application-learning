package com.resume.services.cms;

import com.resume.entities.cms.Contact;
import com.resume.repositories.cms.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> findAll() {
        return this.contactRepository.findAll();
    }

    public void save(Contact contact) {
        this.contactRepository.save(contact);
    }

    public Contact findById(long id) {
        return this.contactRepository.findById(id);
    }

    @Transactional
    public void saveOrUpdate(Contact contact) {
        this.contactRepository.saveOrUpdate(contact);
    }

    public void update(Contact contact) {
        this.contactRepository.update(contact);
    }

    @Transactional
    public void delete(Contact contact) {
        this.contactRepository.delete(contact);
    }

    public Contact getOrSave(long id) {
        Contact contact = this.contactRepository.findById(id);

        if (contact == null) {
            contact = new Contact();
            contact.setId(id);
            this.contactRepository.save(contact);
        }

        return contact;
    }
}
