package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            PreparedStatement stmt = selectUserQuery(username);
            ResultSet rs = stmt.executeQuery();
            return extractFromResult(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error selecting the user.", e);
        }
    }

    public PreparedStatement selectUserQuery(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, username);
        return stmt;
    }

    private User extractFromResult(ResultSet rs) throws SQLException {
        User user = new User();
        if (rs.next()) {
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
        }
        return user;
    }

    @Override
    public Long insert(User user) {
        try {
            PreparedStatement stmt = createUserQuery(user);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch(SQLException e) {
            throw new RuntimeException("Error creating a user on the database.", e);
        }
    }

    public PreparedStatement createUserQuery(User user) throws SQLException {
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, user.getPassword());
        return stmt;
    }
}
