package com.springorm.repository;

import com.springorm.entity.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    HibernateTemplate hibernateTemplate;

    public UserRepositoryImpl (HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<User> getAll() {
        return this.hibernateTemplate.loadAll(User.class);
    }

    @Override
    @Transactional
    public int save(User user) {
        return (int) this.hibernateTemplate.save(user);
    }

    @Override
    public User get(int id) {
        return this.hibernateTemplate.get(User.class, id);
    }

    @Override
    @Transactional
    public void update(User user) {
        this.hibernateTemplate.update(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = this.hibernateTemplate.get(User.class, id);

        if (user != null) {
            this.hibernateTemplate.delete(user);
        }
    }
}
