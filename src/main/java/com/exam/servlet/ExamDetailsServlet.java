package com.exam.servlet;

import com.exam.dao.ExamDao;
import com.exam.dao.ExamDaoImpl;
import com.exam.dao.QuestionDao;
import com.exam.dao.QuestionDaoImpl;
import com.exam.model.Exam;
import com.exam.model.Question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/examDetails")
public class ExamDetailsServlet extends HttpServlet {

    private ExamDao examDao = new ExamDaoImpl();
    private QuestionDao questionDao = new QuestionDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int examId = Integer.parseInt(request.getParameter("examId"));

        Exam exam = examDao.findById(examId);
        List<Question> questions = questionDao.findByExamId(examId);

        request.setAttribute("exam", exam);
        request.setAttribute("questions", questions);

        request.getRequestDispatcher("/views/exam_details.jsp")
                .forward(request, response);
    }
}