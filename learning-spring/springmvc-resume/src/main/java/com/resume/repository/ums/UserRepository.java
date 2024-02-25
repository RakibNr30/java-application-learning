package com.resume.repository.ums;

import com.resume.entity.ums.Role;
import com.resume.entity.ums.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.*;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepository {

    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserRepository(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public List<User> getAll() {
        return this.hibernateTemplate.loadAll(User.class);
    }

    public List<User> getAllByRoleName(String roleName) {

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

    @Transactional
    public void save(User user) {
        this.hibernateTemplate.save(user);
    }

    public User get(long id) {
        return this.hibernateTemplate.get(User.class, id);
    }

    public User getByUsername(String username) {
        DetachedCriteria criteria = DetachedCriteria
                .forEntityName(User.class.getName())
                .add(Restrictions.eq("username", username));

        List<User> users = (List<User>) this.hibernateTemplate.findByCriteria(criteria);

        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User not found.");
        }

        return users.get(0);
    }

    @Transactional
    public void update(User user) {
        this.hibernateTemplate.update(user);
    }

    @Transactional
    public void delete(User user) {
        this.hibernateTemplate.delete(user);
    }
}
