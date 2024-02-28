package com.resume.repositories.ums;

import com.resume.entities.ums.Role;

import java.util.List;

public interface RoleRepository {

    List<Role> findAll();

    void save(Role role);

    Role findById(long id);

    void update(Role role);

    void delete(Role role);
}
