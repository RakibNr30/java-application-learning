package com.resume.services.ums;

import com.resume.entities.ums.Role;
import com.resume.repositories.ums.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }

    public void save(Role role) {
        this.roleRepository.save(role);
    }

    public Role findById(long id) {
        return this.roleRepository.findById(id);
    }

    public void update(Role role) {
        this.roleRepository.update(role);
    }

    @Transactional
    public void delete(Role role) {
        this.roleRepository.delete(role);
    }
}
