package com.exam.servlet;

import com.exam.dao.ExamDao;
import com.exam.dao.ExamDaoImpl;
import com.exam.model.Exam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/createExam")
public class CreateExamServlet extends HttpServlet {

    private ExamDao examDao = new ExamDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String titre = request.getParameter("titre");
        String description = request.getParameter("description");
        int duree = Integer.parseInt(request.getParameter("dureeMinutes"));

        Exam exam = new Exam(titre, description, duree);

        examDao.save(exam);

        response.sendRedirect(request.getContextPath() + "/admin");
    }
}

