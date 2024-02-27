package com.example.blog_app_jakarta_ee.web;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "helloServlet" , urlPatterns = {"/hello-servlet"})
public class RegisterServlet extends HttpServlet {
    private String message;


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("views/login/sing_up.jsp").forward(request, response);
        System.out.println("hello");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy() {
    }
}