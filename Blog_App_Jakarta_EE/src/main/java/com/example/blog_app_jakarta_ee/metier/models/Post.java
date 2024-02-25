package com.example.blog_app_jakarta_ee.metier.models;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {
    private Long id;
    private String title;
    private String content;
    private String image;
    private Date createAt;
    private Long userID;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Post() {
    }

    public Post(String title, String content, String image, Date createAt) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", createAt=" + createAt +
                ", userID=" + userID +
                '}';
    }
}
