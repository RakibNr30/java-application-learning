package com.resume.repositories.ums.impls;

import com.resume.entities.ums.Role;
import com.resume.repositories.ums.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RoleRepositoryHibernateImpl implements RoleRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public RoleRepositoryHibernateImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<Role> findAll() {
        return this.hibernateTemplate.loadAll(Role.class);
    }

    @Override
    @Transactional
    public void save(Role role) {
        this.hibernateTemplate.save(role);
    }

    @Override
    public Role findById(long id) {
        return this.hibernateTemplate.get(Role.class, id);
    }

    @Override
    @Transactional
    public void update(Role role) {
        this.hibernateTemplate.update(role);
    }

    @Override
    @Transactional
    public void delete(Role role) {
        this.hibernateTemplate.delete(role);
    }
}
