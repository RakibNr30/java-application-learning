package com.resume.repository;

import com.resume.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RoleRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public RoleRepository(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public List<Role> getAll() {
        return this.hibernateTemplate.loadAll(Role.class);
    }

    @Transactional
    public void save(Role role) {
        this.hibernateTemplate.save(role);
    }

    public Role get(long id) {
        return this.hibernateTemplate.get(Role.class, id);
    }

    @Transactional
    public void update(Role role) {
        this.hibernateTemplate.update(role);
    }

    @Transactional
    public void delete(Role role) {
        this.hibernateTemplate.delete(role);
    }
}
