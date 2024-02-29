package com.example.blog_app_jakarta_ee.web;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter(urlPatterns = {"/home"})
public class LoginFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false); // Don't create session if it doesn't exist

        // Check if the user is logged in (i.e., session exists)
        if (session != null && session.getAttribute("username") != null) {
            // User is authenticated, continue with the request
            System.out.println("success");

            // Check for session cookie
            Cookie[] cookies = httpRequest.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("sessionId".equals(cookie.getName())) {
                        String sessionId = cookie.getValue();
                        // Do something with sessionId
                        System.out.println("SessionId found: " + sessionId);
                        break;
                    }
                }
            }

            chain.doFilter(request, response);
        } else {
            // User is not authenticated, redirect to login page
            httpResponse.sendRedirect(httpRequest.getContextPath()+"/");
            System.out.println("failed");
        }
    }
}
