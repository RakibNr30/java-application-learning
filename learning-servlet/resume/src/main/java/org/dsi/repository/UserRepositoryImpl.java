package org.dsi.repository;

import org.dsi.entity.User;
import org.dsi.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository, AutoCloseable {

    private final Connection connection;

    public UserRepositoryImpl () {
        connection = DBUtil.getConnection();
    }

    @Override
    public void save(User user) {
        try {
            String query = "INSERT INTO users(name, email, mobile, dob) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getMobile());
            preparedStatement.setDate(4, Date.valueOf(user.getDob()));
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try {
            String query = "UPDATE users SET name=?, email=?, mobile=?, dob=? WHERE id=?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getMobile());
            preparedStatement.setDate(4, Date.valueOf(user.getDob()));
            preparedStatement.setInt(5, user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try {
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);

            preparedStatement.setInt(1, user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        try {
            String query = "SELECT id, name, email, mobile, dob, created_at, updated_at FROM users ORDER BY id";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = this.getUserFromResultSet(resultSet);
                users.add(user);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User getById(int id) {
        User user = null;

        try {
            String query = "SELECT id, name, email, mobile, dob, created_at, updated_at FROM users WHERE id = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = this.getUserFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    private User getUserFromResultSet(ResultSet resultSet) {
        User user = new User();

        try {
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setMobile(resultSet.getString("mobile"));
            user.setDob(resultSet.getDate("dob").toLocalDate());
            user.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
            user.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void close() throws Exception {
        DBUtil.closeConnection(this.connection);
    }
}
