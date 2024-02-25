package com.example.blog_app_jakarta_ee.Dao;

import com.example.blog_app_jakarta_ee.Dao.user.UserDaoImpl;
import com.example.blog_app_jakarta_ee.metier.models.User;

import javax.xml.crypto.Data;
import java.time.LocalTime;

public class TestDao {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setEmail("alilinabouig132@gmail.com");
        user.setFirstName("linaboui");
        user.setLastName("ali");
        user.setPassword("ali123");
        user.setImageUrl("Image/ims/ali.png");
        user.setCreatedAt(new Data() {});
        userDao.addUser(user);

        user = userDao.getUserById(2);
    }
}
