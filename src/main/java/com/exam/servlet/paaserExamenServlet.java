package com.exam.servlet;

import com.exam.dao.ExamDao;
import com.exam.dao.ExamDaoImpl;
import com.exam.model.Exam;
import com.exam.model.Question;
import com.exam.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/passerExamen")
public class paaserExamenServlet extends HttpServlet {

    private ExamDao examDao = new ExamDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if (session.getAttribute("questions") == null) {
            String idParam = request.getParameter("id");
            if (idParam == null) {
                response.sendRedirect("listeExamens.jsp");
                return;
            }

            int examId = Integer.parseInt(idParam);
            // Utilisation de ta méthode findById
            Exam exam = examDao.findById(examId);
            
            if (exam != null && exam.getDescription() != null) {
                String questions = exam.getDescription();
                
                // Logique : Ordre aléatoire (Demandé par le Use Case)
                //Collections.shuffle(questions);
                
                session.setAttribute("questions", questions);
                session.setAttribute("currentIndex", 0);
                session.setAttribute("score", 0);
                session.setAttribute("currentExamId", examId);
            }
        }

        List<Question> questions = (List<Question>) session.getAttribute("questions");
        Integer currentIndex = (Integer) session.getAttribute("currentIndex");

        if (questions != null && currentIndex < questions.size()) {
            request.setAttribute("question", questions.get(currentIndex));
            request.getRequestDispatcher("examen.jsp").forward(request, response);
        } else {
            response.sendRedirect("resultat.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Question> questions = (List<Question>) session.getAttribute("questions");
        int currentIndex = (int) session.getAttribute("currentIndex");

        // Récupération du choix de l'étudiant
        String reponseId = request.getParameter("reponse");
        Question q = questions.get(currentIndex);

        // Simulation de vérification (à adapter selon ton modèle Question/Option)
        if (reponseId != null && reponseId.equals(String.valueOf(q.getId()))) {
            int score = (int) session.getAttribute("score");
            session.setAttribute("score", score + 1);
        }

        // Questions affichées une par une
        int nextIndex = currentIndex + 1;
        session.setAttribute("currentIndex", nextIndex);

        if (nextIndex >= questions.size()) {
            // Logique : Sauvegarder résultat en base
            // Note : Tu devrais normalement avoir une méthode dans un DAO pour cela
            // Exemple : resultDao.saveScore(userId, examId, score);
            
            response.sendRedirect("resultat.jsp");
        } else {
            response.sendRedirect("passerExamen");
        }
    }
}