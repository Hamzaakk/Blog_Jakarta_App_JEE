package com.example.blog_app_jakarta_ee.web;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import com.example.blog_app_jakarta_ee.Dao.post.IPostDao;
import com.example.blog_app_jakarta_ee.Dao.post.PostDaoImpl;
import com.example.blog_app_jakarta_ee.metier.models.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = {"/home" , "/addNewPost" ,"*.php"})
public class HelloServlet extends HttpServlet {
    private String message;
    private IPostDao metier;

    public void init() {
        metier=new PostDaoImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletPath();
        if (path.equals("/home")) {
            request.getRequestDispatcher("views/home.jsp").forward(request,response);
        } else if (path.equals("/addNewPost")) {
         request.getRequestDispatcher("views/addNewPost.jsp").forward(request, response);
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

            System.out.println(title + "  " + details);

        }
    }
}