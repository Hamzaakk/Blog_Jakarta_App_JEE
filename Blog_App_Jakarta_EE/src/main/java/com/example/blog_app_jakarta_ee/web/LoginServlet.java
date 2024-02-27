package com.example.blog_app_jakarta_ee.web;

import com.example.blog_app_jakarta_ee.Dao.post.PostDaoImpl;
import com.example.blog_app_jakarta_ee.Dao.user.IUserDao;
import com.example.blog_app_jakarta_ee.Dao.user.UserDaoImpl;
import com.example.blog_app_jakarta_ee.metier.models.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "loginServlet" , urlPatterns = {"*.do"})
public class LoginServlet extends HttpServlet {
    private User user ;
    private IUserDao userDao;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("views/login/index.jsp").forward(request,response);
        System.out.println("hello login");
    }

    public void init() {
       user = new User();
       userDao = new UserDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post the login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        user = userDao.authenticate(email,password);
        if ( user.getUserId() != 0) {
            HttpSession session = request.getSession();

            session.setAttribute("username", user.getFirstName());
            session.setAttribute("user_id", user.getUserId());

            // Set cookie for session management
            Cookie sessionCookie = new Cookie("sessionId", session.getId());

            response.addCookie(sessionCookie);
            System.out.println(session.getId());

            // Redirect to some authenticated page
            response.sendRedirect("home");

        }else{
            request.getRequestDispatcher("views/login/index.jsp").forward(request,response);

        }

    }
}
