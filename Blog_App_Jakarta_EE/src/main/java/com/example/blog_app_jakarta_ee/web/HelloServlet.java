package com.example.blog_app_jakarta_ee.web;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import com.example.blog_app_jakarta_ee.Dao.post.IPostDao;
import com.example.blog_app_jakarta_ee.Dao.post.PostDaoImpl;
import com.example.blog_app_jakarta_ee.metier.models.Post;
import com.example.blog_app_jakarta_ee.services.Services;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = {"/delete","/edit","/home" , "/addNewPost" ,"*.php"})
@MultipartConfig
public class HelloServlet extends HttpServlet {
    private String message;
    private IPostDao metier;
    private Post post;

    public void init() {
        metier=new PostDaoImpl();
        post = new Post();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletPath();
        if (path.equals("/home")) {
            try {
                List<Post> allPost = metier.getPosts();
                request.setAttribute("allPosts", allPost);
                for (Post post1:allPost){
                    System.out.println(post1.getTitle());
                    System.out.println(post1.getImage());
                }
                request.getRequestDispatcher("views/home.jsp").forward(request,response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (path.equals("/addNewPost")) {
         request.getRequestDispatcher("views/addNewPost.jsp").forward(request, response);
        }else if(path.equals("/update.php")){
            Long id = Long.parseLong(request.getParameter("id"));
            System.out.println(id);
            post=metier.getPostsById(id);
            System.out.println(post.toString());
            request.setAttribute("post", post);
            request.getRequestDispatcher("views/updatePost.jsp").forward(request, response);
        }else if(path.equals("/delete.php")){
            Long id = Long.parseLong(request.getParameter("id"));
            metier.deletePost(id);
            response.sendRedirect("home");
        }
    }



    public void destroy() {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/addNewPost.php")) {
            String title = request.getParameter("title");
            String details= request.getParameter("details");
            String image = request.getParameter("image");
            post.setTitle(title);

            // Print or use the current directory path
            String uploadDirectory = "C:\\Users\\DELL VOS\\OneDrive\\Bureau\\Blog_Jakarta_App_JEE\\Blog_App_Jakarta_EE\\src\\main\\webapp\\WEB-INF\\images\\upload";
            String fileName = Services.uploadImageTOServergetByPostRequest(uploadDirectory,request);
            String imagePath = fileName;
            post.setImage(imagePath);
            post.setContent(details);
            try{
                post=metier.AddNewPost(post);
                response.sendRedirect("home");
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else if (path.equals("/edit.php")) {
            Post postUpdated = new Post();
            //get parameters
            Long id = Long.parseLong(request.getParameter("id"));
            Long id_u = Long.parseLong(request.getParameter("id_u"));
            String title = request.getParameter("title");
            String details= request.getParameter("details");
            String image = request.getParameter("image");
            //upload image here
            String uploadDirectory = "C:\\Users\\DELL VOS\\OneDrive\\Bureau\\Blog_Jakarta_App_JEE\\Blog_App_Jakarta_EE\\src\\main\\webapp\\WEB-INF\\images\\upload";
            String fileName = Services.uploadImageTOServergetByPostRequest(uploadDirectory,request);
            String imagePath = fileName;
            //set parameters
            postUpdated.setTitle(title);
            postUpdated.setId(id);
            postUpdated.setUserID(id_u);
            postUpdated.setImage(imagePath);
            postUpdated.setContent(details);
            try{
                post=metier.updatePost(postUpdated);
                System.out.println(path.toString());
                response.sendRedirect("home");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}