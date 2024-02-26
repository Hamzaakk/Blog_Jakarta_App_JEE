package com.example.blog_app_jakarta_ee.Dao;

import com.example.blog_app_jakarta_ee.Dao.user.UserDaoImpl;
import com.example.blog_app_jakarta_ee.metier.models.User;

import javax.xml.crypto.Data;
import java.time.LocalTime;

public class TestDao {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setEmail("wiam@gmail.com");
        user.setFirstName("waim");
        user.setLastName("charifi");
        user.setPassword("ch1234");
        user.setImageUrl("Images/ims/wiam.png");

       // userDao.addUser(user);

        user = userDao.getUserById(6);
        System.out.println(user.toString());

        User newUser = new User();
       newUser = userDao.authenticate("wiamf@gmail.com","ch1234");
    }
}
