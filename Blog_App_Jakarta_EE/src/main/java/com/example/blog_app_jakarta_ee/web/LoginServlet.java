package com.example.blog_app_jakarta_ee.web;


import com.example.blog_app_jakarta_ee.Dao.post.IPostDao;
import com.example.blog_app_jakarta_ee.Dao.post.PostDaoImpl;
import com.example.blog_app_jakarta_ee.Dao.user.IUserDao;
import com.example.blog_app_jakarta_ee.Dao.user.UserDaoImpl;
import com.example.blog_app_jakarta_ee.metier.models.Post;
import com.example.blog_app_jakarta_ee.metier.models.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "loginServlet" , urlPatterns = {"/register","/","*.do"})
public class LoginServlet extends HttpServlet {
    private User user;
    private IUserDao userDao;
    public void init() {
        user = new User();
        userDao = new UserDaoImpl();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletPath();
        if (path.equals("/")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (path.equals("/register")) {
            request.getRequestDispatcher("views/login/sing_up.jsp").forward(request, response);
        }

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/login.do")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            user = userDao.authenticate(email, password);
            if (user.getUserId() != 0) {
                // Invalidate existing session
                HttpSession existingSession = request.getSession(false);
                if (existingSession != null) {
                    existingSession.invalidate();
                }


                // Create a new session
                HttpSession session = request.getSession(true);

                session.setAttribute("username", user.getFirstName());
                session.setAttribute("user_id", user.getUserId());

                // Set cookie for session management
                Cookie sessionCookie = new Cookie("sessionId", session.getId());
                response.addCookie(sessionCookie);
                System.out.println(session.getId());

                // Redirect to some authenticated page
                response.sendRedirect("home");
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else if (path.equals("/register.do")) {
            String f_name = request.getParameter("f-name");
            String l_name = request.getParameter("l-name");
            String email  = request.getParameter("email");
            String password = request.getParameter("password");
            String image = request.getParameter("image");
            if (userDao.checkInput(f_name,l_name,email,password,image)){
                User newUser=new User();
                newUser.setFirstName(f_name);
                newUser.setLastName(l_name);
                newUser.setEmail(email);
                newUser.setPassword(password);
                newUser.setImageUrl(image);

                try {
                    user = userDao.addUser(newUser);
                    request.setAttribute("newUser", user);
                    response.sendRedirect("home");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
