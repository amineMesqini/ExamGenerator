package com.exam.servlet;

import com.exam.dao.ExamDao;
import com.exam.dao.ExamDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/toggleExam")
public class ToggleExamServlet extends HttpServlet {

    private ExamDao examDao = new ExamDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int examId = Integer.parseInt(request.getParameter("examId"));
        boolean active = Boolean.parseBoolean(request.getParameter("active"));

        examDao.toggleActive(examId, active);

        response.sendRedirect(request.getContextPath() + "/admin");
    }
}