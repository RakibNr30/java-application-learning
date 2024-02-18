package com.security.repository;

import com.security.dto.SignUpDTO;

public interface SignUpRepository {
    void save(SignUpDTO signUpDTO);
}
