package org.dsi.repository;

import org.dsi.entity.User;
import java.util.List;

public interface UserRepository {
    void save(User user);
    void update(User user);
    void delete(User user);
    List<User> getAll();
    User getById(int id);
}
