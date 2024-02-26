package com.example.blog_app_jakarta_ee.Dao.user;

import com.example.blog_app_jakarta_ee.metier.models.User;

import java.sql.SQLException;

public interface IUserDao {
 public User addUser(User user) throws SQLException;
 public User getUserById(int UserId);
 public boolean authenticate(String email, String password);

}
