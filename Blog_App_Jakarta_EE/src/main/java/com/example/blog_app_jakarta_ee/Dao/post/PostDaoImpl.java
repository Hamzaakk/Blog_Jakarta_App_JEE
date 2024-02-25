package com.example.blog_app_jakarta_ee.Dao.post;

import com.example.blog_app_jakarta_ee.Dao.connection.SingletonConnection;
import com.example.blog_app_jakarta_ee.metier.models.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public List<Post> getPostsById(Long id) {
        return null;
    }

    @Override
    public List<Post> getPostsByKey(String key) {
        return null;
    }

    @Override
    public Post AddNewPost(Post post) {
        return null;
    }

    @Override
    public Post updatePost(Post p) {
        return null;
    }

    @Override
    public Post deletePost(Long id) {
        return null;
    }
}
