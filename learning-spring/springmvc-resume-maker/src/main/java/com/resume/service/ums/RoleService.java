package com.resume.service.ums;

import com.resume.entity.ums.Role;
import com.resume.repository.ums.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Role save(Role role) {
        return this.roleRepository.save(role);
    }

    public Role findById(Long id) {
        return this.roleRepository.findById(id).orElse(null);
    }

    public Role update(Role role) {
        return this.roleRepository.save(role);
    }

    public void delete(Role role) {
        this.roleRepository.delete(role);
    }
}
