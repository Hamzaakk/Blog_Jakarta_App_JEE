package com.example.blog_app_jakarta_ee.Dao.user;

import com.example.blog_app_jakarta_ee.Dao.connection.SingletonConnection;
import com.example.blog_app_jakarta_ee.metier.models.User;

import javax.xml.crypto.Data;
import java.sql.*;

public class UserDaoImpl implements IUserDao {
    @Override
    public User addUser(User user) {

        Connection connection= SingletonConnection.getConnection();
        String query = "INSERT INTO users (email,password,first_name,last_name,image_url,created_at) VALUES (?,?,?,?,?,current_time())" ;
        try{
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1,user.getEmail());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getFirstName());
            ps.setString(4,user.getLastName());
            ps.setString(5,user.getImageUrl());
          //  ps.setDate(6,null);

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
        String query = "SELECT * FROM users WHERE user_id = ?" ;
        try{
            PreparedStatement ps = connection.prepareStatement(query);

           ps.setInt(1,UserId);
           ResultSet result =  ps.executeQuery();

            if (result.next()){

                user.setUserId(result.getInt("User_id"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setImageUrl(result.getString("image_url"));
                user.setCreatedAt(result.getDate("created_at"));
            }
            // we dose not close connection : we use singleton
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return user;

    }

    @Override
    public User authenticate(String email, String password) {
        Connection connection = SingletonConnection.getConnection();
        User user = new User();
        String query = "SELECT * FROM users where email = ? and password = ?" ;
        try{
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1,email);
            st.setString(2,password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              user = getUserById(rs.getInt("user_id"));
                System.out.println("user existe " +user.getUserId());
            }
        }catch(Exception exception) {
            exception.printStackTrace();
        }
        System.out.println(user.getUserId());
        return user;
    }
    @Override
    public boolean checkInput(String f_name, String l_name, String email, String password, String image){
        return !f_name.trim().isEmpty() &&!l_name.trim().isEmpty() &&!email.trim().isEmpty() &&!password.trim().isEmpty() &&!image.trim().isEmpty() ;
    }
}
