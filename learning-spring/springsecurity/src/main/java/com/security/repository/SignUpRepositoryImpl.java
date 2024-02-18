package com.security.repository;

import com.security.dto.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SignUpRepositoryImpl implements SignUpRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(SignUpDTO signUpDTO) {
        String query = "INSERT INTO users VALUES (?, ?, ?)";
        String queryAuth = "INSERT INTO authorities VALUES (?, ?)";
        jdbcTemplate.update(query, signUpDTO.getUsername(), signUpDTO.getPassword(), true);

        for (String role : signUpDTO.getRoles()) {
            jdbcTemplate.update(queryAuth, signUpDTO.getUsername(), "ROLE_" + role);
        }
    }
}
