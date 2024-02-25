package com.example.blog_app_jakarta_ee.metier.models;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.time.LocalTime;

public class User {
    private int UserId;
    private String firstName ;
    private String lastName;

    private String imageUrl;

    private Data createdAt;
    private String email;
    private String password;
    public User() {}
    public User(String firstName, String lastName, String imageUrl, Data createdAt, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreatedAt() {
        return (Date) createdAt;
    }

    public void setCreatedAt(Data createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
