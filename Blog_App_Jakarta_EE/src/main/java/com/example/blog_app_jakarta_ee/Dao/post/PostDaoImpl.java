package com.example.blog_app_jakarta_ee.Dao.post;

import com.example.blog_app_jakarta_ee.Dao.connection.SingletonConnection;
import com.example.blog_app_jakarta_ee.metier.models.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImpl implements IPostDao{
    @Override
    public List<Post> getPosts(){
        List<Post> posts = new ArrayList<>();
        Post p;
        Connection connection = SingletonConnection.getConnection();
        String query = "select * from posts";
        try{
            PreparedStatement pr =connection.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                p=new Post();
                p.setId(rs.getLong("post_id"));
                p.setTitle(rs.getString("title"));
                p.setImage(rs.getString("image_url"));
                p.setContent(rs.getString("content"));
                p.setCreateAt(rs.getDate("created_at"));
                p.setUserID(rs.getLong("user_id"));
                posts.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public Post getPostsById(Long id) {
        Post post = null;
        Connection connection = SingletonConnection.getConnection();
        String query = "select * from posts where post_id=?";
        try {
            PreparedStatement pr = connection.prepareStatement(query);
            pr.setLong(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                post = new Post();
                post.setId(rs.getLong("post_id"));
                post.setTitle(rs.getString("title"));
                post.setImage(rs.getString("image_url"));
                post.setContent(rs.getString("content"));
                post.setCreateAt(rs.getDate("created_at"));
                post.setUserID(rs.getLong("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public List<Post> getPostsByKey(String key) {
        List<Post> posts = new ArrayList<>();
        Connection connection = SingletonConnection.getConnection();
        String query = "SELECT * FROM posts WHERE title LIKE ?";
        try {
            PreparedStatement pr = connection.prepareStatement(query);
            pr.setString(1, "%" + key + "%");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getLong("post_id"));
                post.setTitle(rs.getString("title"));
                post.setImage(rs.getString("image_url"));
                post.setContent(rs.getString("content"));
                post.setCreateAt(rs.getDate("created_at"));
                post.setUserID(rs.getLong("user_id"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public Post AddNewPost(Post post) {
        Connection connection = SingletonConnection.getConnection();
        String query = "INSERT INTO posts (title, image_url, content, created_at) VALUES (?, ?, ?,current_time())";
        try {
            PreparedStatement pr = connection.prepareStatement(query);
            pr.setString(1, post.getTitle());
            pr.setString(2, post.getImage());
            pr.setString(3, post.getContent());

            pr.executeUpdate();


            PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(post_id) AS MAXID from posts ");

            ResultSet result = ps2.executeQuery();
            if (result.next()){
                post.setId(result.getLong("MAXID"));

                post = getPostsById(result.getLong("MAXID"));


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public Post updatePost(Post post) {
        Connection connection = SingletonConnection.getConnection();
        String query = "UPDATE posts SET title=?, image_url=?, content=?, created_at=current_time(), user_id=? WHERE post_id=?";
        try {
            PreparedStatement pr = connection.prepareStatement(query);
            pr.setString(1, post.getTitle());
            pr.setString(2, post.getImage());
            pr.setString(3, post.getContent());
            pr.setLong(4, post.getUserID());
            pr.setLong(5, post.getId());
            int affectedRows = pr.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating post failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public void deletePost(Long id) {
        Connection connection = SingletonConnection.getConnection();
        String query = "DELETE FROM posts WHERE post_id=?";
        try {
            PreparedStatement pr = connection.prepareStatement(query);
            pr.setLong(1, id);
            int affectedRows = pr.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting post failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
