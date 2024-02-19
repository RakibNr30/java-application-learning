package com.resume.service;

import com.resume.entity.Role;
import com.resume.repository.RoleRepository;
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

    public List<Role> getAll() {
        return this.roleRepository.getAll();
    }

    public void save(Role role) {
        this.roleRepository.save(role);
    }

    public Role get(long id) {
        return this.roleRepository.get(id);
    }

    public void update(Role role) {
        this.roleRepository.update(role);
    }

    @Transactional
    public void delete(Role role) {
        this.roleRepository.delete(role);
    }
}
