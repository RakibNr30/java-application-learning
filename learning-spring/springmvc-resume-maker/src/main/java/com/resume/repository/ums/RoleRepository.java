package com.resume.repository.ums;

import com.resume.entity.ums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAllByName(String name);
}
