package com.exam.servlet;

import com.exam.dao.UserDao;
import com.exam.dao.UserDaoImpl;
import com.exam.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDao userDao = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("EMAIL SAISI: " + email);
        System.out.println("PASSWORD SAISI: " + password);

        User user = userDao.findByEmail(email);

        System.out.println("USER TROUVE: " + user);

        if (user != null) {
            System.out.println("PASSWORD EN BASE: " + user.getPassword());
        }

        if (user != null && user.getPassword().equals(password)) {

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if ("ADMIN".equals(user.getRole())) {
                response.sendRedirect(request.getContextPath() + "/admin.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/student.jsp");
            }

        } else {
            System.out.println("LOGIN FAILED");
            response.getWriter().println("Email ou mot de passe incorrect !");
        }
    }
}