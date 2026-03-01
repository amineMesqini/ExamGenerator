package com.exam.servlet;

import com.exam.dao.QuestionDao;
import com.exam.dao.QuestionDaoImpl;
import com.exam.dao.OptionDao;
import com.exam.dao.OptionDaoImpl;
import com.exam.model.Question;
import com.exam.model.Option;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/addQuestion")
public class AddQuestionServlet extends HttpServlet {

    private QuestionDao questionDao = new QuestionDaoImpl();
    private OptionDao optionDao = new OptionDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int examId = Integer.parseInt(request.getParameter("examId"));
        String contenu = request.getParameter("contenu");
        String type = request.getParameter("typeQuestion");
        float points = Float.parseFloat(request.getParameter("points"));

        Question question = new Question(examId, contenu, type, points, null);

        // 1️⃣ Insert question
        int questionId = questionDao.save(question);

        // 2️⃣ If QCM → Insert options
        if ("QCM".equals(type)) {

            String[] options = request.getParameterValues("options");
            String correctIndex = request.getParameter("correctOption");

            if (options != null) {
                for (int i = 0; i < options.length; i++) {

                    boolean isCorrect = String.valueOf(i).equals(correctIndex);

                    Option option = new Option(
                            questionId,
                            options[i],
                            isCorrect
                    );

                    optionDao.save(option);
                }
            }
        }
        response.sendRedirect(
                request.getContextPath() + "/examDetails?examId=" + examId
        );


    }
}