<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.exam.model.Exam" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin - Gestion des Examens</title>
    <style>
        body {
            font-family: Arial;
            background-color: #f4f6f9;
            padding: 30px;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px #ddd;
        }
        .exam {
            padding: 15px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 6px;
        }
        .btn {
            padding: 6px 12px;
            text-decoration: none;
            background: #007bff;
            color: white;
            border-radius: 4px;
            font-size: 14px;
        }
        .btn-secondary {
            background: #28a745;
        }
        .btn-danger {
            background: #dc3545;
        }
    </style>
</head>
<body>

<div class="container">

    <h2>📘 Espace Admin</h2>

    <br>

    <!-- Bouton créer exam -->
    <a class="btn btn-secondary"
       href="${pageContext.request.contextPath}/views/create_exam.jsp">
        ➕ Créer un nouvel examen
    </a>

    <hr>

    <h3>📋 Liste des Examens</h3>

    <%


        List<Exam> exams = (List<Exam>) request.getAttribute("exams");

        if (exams == null || exams.isEmpty()) {
    %>
    <p>Aucun examen disponible.</p>
    <%
    } else {
        for (Exam exam : exams) {
    %>

    <div class="exam">
        <h4><%= exam.getTitre() %></h4>

        <p><b>Description :</b> <%= exam.getDescription() %></p>
        <p><b>Durée :</b> <%= exam.getDureeMinutes() %> minutes</p>

        <a class="btn"
           href="${pageContext.request.contextPath}/views/add_question.jsp?examId=<%= exam.getId() %>">
            ➕ Ajouter Question
        </a>

    </div>

    <%
            }
        }
    %>

</div>

</body>
</html>