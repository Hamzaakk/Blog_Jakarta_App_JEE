package com.example.blog_app_jakarta_ee.Dao.user;

import com.example.blog_app_jakarta_ee.Dao.connection.SingletonConnection;
import com.example.blog_app_jakarta_ee.metier.models.User;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    @Override
    public User addUser(User user) {

        Connection connection= SingletonConnection.getConnection();
        String query = "INSERT INTO users (email,password,first_name,last_name,image_url,created_at) VALUES (?,?,?,?,?,?)" ;
        try{
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1,user.getEmail());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getFirstName());
            ps.setString(4,user.getLastName());
            ps.setString(5,user.getImageUrl());
            ps.setDate(6,null);

            ps.executeUpdate();


            PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(user_id) AS MAXID from users ");

            ResultSet result = ps2.executeQuery();
            if (result.next()){
                user.setUserId(result.getInt("MAXID"));
                System.out.println(user.getUserId());
            }
           // we dose not close connection : we use singleton
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

    @Override
    public User getUserById(int UserId) {
        User user = new User();
        Connection connection= SingletonConnection.getConnection();
        String query = "SELECT * FROM users" ;
        try{
            PreparedStatement ps = connection.prepareStatement(query);


           ResultSet result =  ps.executeQuery();



            if (result.next()){

                user.setUserId(result.getInt("User_id"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setImageUrl(result.getString("image_url"));
                user.setCreatedAt((Data) result.getDate("created_at"));




            }
            // we dose not close connection : we use singleton
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return user;

    }
}
