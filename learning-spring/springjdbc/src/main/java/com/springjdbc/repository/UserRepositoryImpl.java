package com.springjdbc.repository;

import com.springjdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userRepository")
public class UserRepositoryImpl implements UserRepository {

    /* Automatic dependency inject */
   @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(User user) {
        String query = "INSERT INTO users(name, email, address) VALUES (?, ?, ?)";
        return this.jdbcTemplate.update(query, user.getName(), user.getEmail(), user.getAddress());
    }

    @Override
    public int update(User user) {
        String query = "UPDATE users SET name = ?, email = ?, address = ? WHERE id = ?";
        return this.jdbcTemplate.update(query, user.getName(), user.getEmail(), user.getAddress(), user.getId());
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        return this.jdbcTemplate.update(query, id);
    }

    @Override
    public User get(int id) {
        String query = "SELECT * FROM users WHERE id = ?";

        RowMapper<User> rowMapper = new UserRowMapperImpl();

        return this.jdbcTemplate.queryForObject(query, rowMapper, id);
    }

    @Override
    public List<User> getAll() {
        String query = "SELECT * FROM users";

        return jdbcTemplate.query(query, new UserRowMapperImpl());
    }
}
