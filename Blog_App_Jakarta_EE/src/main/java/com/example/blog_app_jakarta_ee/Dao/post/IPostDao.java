package com.example.blog_app_jakarta_ee.Dao.post;

import com.example.blog_app_jakarta_ee.metier.models.Post;

import java.sql.SQLException;
import java.util.List;

public interface IPostDao {
    public List<Post> getPosts() throws SQLException;
    public Post getPostsById(Long id);
    public List<Post> getPostsByKey(String key);
    public Post AddNewPost(Post post);
    public Post updatePost(Post p);
    public void deletePost(Long id);
}
