package com.exam.servlet;

import com.exam.dao.ExamDao;
import com.exam.dao.ExamDaoImpl;
import com.exam.model.Exam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private ExamDao examDao = new ExamDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Exam> exams = examDao.findAll();
        request.setAttribute("exams", exams);


        request.getRequestDispatcher("/admin.jsp")
                .forward(request, response);
        System.out.println("Nombre d'exams : " + exams.size());
    }
}
