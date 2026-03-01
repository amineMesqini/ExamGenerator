package com.exam.servlet;

import com.exam.dao.QuestionDao;
import com.exam.dao.QuestionDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteQuestion")
public class DeleteQuestionServlet extends HttpServlet {

    private QuestionDao questionDao = new QuestionDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int questionId = Integer.parseInt(request.getParameter("questionId"));
        int examId = Integer.parseInt(request.getParameter("examId"));

        questionDao.delete(questionId);

        response.sendRedirect(
                request.getContextPath() + "/examDetails?examId=" + examId
        );
    }
}