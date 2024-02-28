package com.resume.repositories.ums.impls;

import com.resume.entities.ums.Role;
import com.resume.entities.ums.User;
import com.resume.repositories.ums.UserRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepositoryHibernateImpl implements UserRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserRepositoryHibernateImpl(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<User> findAll() {
        return this.hibernateTemplate.loadAll(User.class);
    }

    @Override
    public List<User> findAllByRoleName(String roleName) {

        DetachedCriteria subCriteria = DetachedCriteria
                .forEntityName(Role.class.getName())
                .add(Restrictions.eq("name", roleName))
                .setProjection(Projections.property("id"));

        DetachedCriteria criteria = DetachedCriteria
                .forEntityName(User.class.getName(), "u")
                .createAlias("u.roles", "ur", JoinType.LEFT_OUTER_JOIN)
                .add(Subqueries.propertyIn("ur.id", subCriteria))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        return (List<User>) this.hibernateTemplate.findByCriteria(criteria);
    }

    @Override
    @Transactional
    public void save(User user) {
        this.hibernateTemplate.save(user);
    }

    @Override
    public User findById(long id) {
        return this.hibernateTemplate.get(User.class, id);
    }

    @Override
    public User findByUsername(String username) {
        DetachedCriteria criteria = DetachedCriteria
                .forEntityName(User.class.getName())
                .add(Restrictions.eq("username", username));

        List<User> users = (List<User>) this.hibernateTemplate.findByCriteria(criteria);

        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User not found.");
        }

        return users.get(0);
    }

    @Override
    @Transactional
    public void update(User user) {
        this.hibernateTemplate.update(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        this.hibernateTemplate.delete(user);
    }
}
