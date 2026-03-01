<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.exam.model.Question" %>
<%@ page import="com.exam.model.Exam" %>

<%
  Exam exam = (Exam) request.getAttribute("exam");
  List<Question> questions = (List<Question>) request.getAttribute("questions");
%>

<!DOCTYPE html>
<html>
<head>
  <title>Détails Examen</title>
</head>
<body>

<h2>Détails de l'examen</h2>

<% if (exam != null) { %>
<h3><%= exam.getTitre() %></h3>
<p>Description : <%= exam.getDescription() %></p>
<p>Durée : <%= exam.getDureeMinutes() %> minutes</p>
<% } %>

<hr>

<h3>Questions :</h3>

<% if (questions == null || questions.isEmpty()) { %>
<p>Aucune question pour cet examen.</p>
<% } else {
  for (Question q : questions) { %>

<div>
  <p><b><%= q.getContenu() %></b></p>
  <p>Type : <%= q.getTypeQuestion() %></p>
  <p>Points : <%= q.getPoints() %></p>

  <a style="color:red;"
     href="<%= request.getContextPath() %>/deleteQuestion?questionId=<%= q.getId() %>&examId=<%= exam.getId() %>"
     onclick="return confirm('Supprimer cette question ?')">
    🗑 Supprimer
  </a>
</div>
<hr>
<hr>

<%     }
} %>

<br>

<a href="<%= request.getContextPath() %>/views/add_question.jsp?examId=<%= exam.getId() %>">
  Ajouter une autre question
</a>

<br><br>

<a href="<%= request.getContextPath() %>/admin">
  Retour Admin
</a>

</body>
</html>