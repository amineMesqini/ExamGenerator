package com.exam.servlet;

import com.exam.dao.ResultDao;
import com.exam.dao.ResultDaoImpl;
import com.exam.model.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/results")
public class ResultsServlet extends HttpServlet {

    private ResultDao resultDao = new ResultDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int examId = Integer.parseInt(request.getParameter("examId"));

        List<Result> results = resultDao.findByExamId(examId);

        request.setAttribute("results", results);
        request.setAttribute("examId", examId);

        request.getRequestDispatcher("/views/results.jsp")
                .forward(request, response);
    }
}