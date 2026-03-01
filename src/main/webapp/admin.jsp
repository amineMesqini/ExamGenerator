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
            margin-right: 5px;
        }
        .btn-secondary {
            background: #28a745;
        }
        .btn-danger {
            background: #dc3545;
        }
        .btn-warning {
            background: #ffc107;
            color: black;
        }
        .status {
            font-weight: bold;
        }
        .active {
            color: green;
        }
        .inactive {
            color: red;
        }
    </style>
</head>
<body>

<div class="container">

    <h2>📘 Espace Admin</h2>

    <br>

    <!-- Bouton créer exam -->
    <a class="btn btn-secondary"
       href="<%= request.getContextPath() %>/views/create_exam.jsp">
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

        <p class="status">
            Statut :
            <% if (exam.isActive()) { %>
            <span class="active">ACTIF</span>
            <% } else { %>
            <span class="inactive">INACTIF</span>
            <% } %>
        </p>

        <!-- Voir détails -->
        <a class="btn"
           href="<%= request.getContextPath() %>/examDetails?examId=<%= exam.getId() %>">
            📄 Voir Détails
        </a>

        <!-- Ajouter question -->
        <a class="btn btn-secondary"
           href="<%= request.getContextPath() %>/views/add_question.jsp?examId=<%= exam.getId() %>">
            ➕ Ajouter Question
        </a>

        <!-- Activer / Désactiver -->
        <% if (exam.isActive()) { %>
        <a class="btn btn-warning"
           href="<%= request.getContextPath() %>/toggleExam?examId=<%= exam.getId() %>&active=false">
            Désactiver
        </a>
        <% } else { %>
        <a class="btn btn-warning"
           href="<%= request.getContextPath() %>/toggleExam?examId=<%= exam.getId() %>&active=true">
            Activer
        </a>
        <a class="btn"
           href="<%= request.getContextPath() %>/results?examId=<%= exam.getId() %>">
            📊 Voir Résultats
        </a>
        <% } %>

        <!-- Supprimer (à implémenter si pas encore fait) -->
        <a class="btn btn-danger"
           href="<%= request.getContextPath() %>/deleteExam?examId=<%= exam.getId() %>"
           onclick="return confirm('Confirmer la suppression ?')">
            🗑 Supprimer
        </a>

    </div>

    <%
            }
        }
    %>

</div>

</body>
</html>