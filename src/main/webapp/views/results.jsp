<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.exam.model.Result" %>

<%
    List<Result> results = (List<Result>) request.getAttribute("results");
    int examId = (int) request.getAttribute("examId");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Résultats Examen</title>
</head>
<body>

<h2>📊 Résultats de l'examen</h2>

<% if (results == null || results.isEmpty()) { %>
<p>Aucun résultat disponible.</p>
<% } else { %>

<table border="1" cellpadding="10">
    <tr>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Score</th>
        <th>Temps (sec)</th>
        <th>Date</th>
    </tr>

    <% for (Result r : results) { %>
    <tr>
        <td><%= r.getNom() %></td>
        <td><%= r.getPrenom() %></td>
        <td><%= r.getScore() %></td>
        <td><%= r.getTempsPasseSecondes() %></td>
        <td><%= r.getDateTentative() %></td>
    </tr>
    <% } %>
</table>

<% } %>

<br>
<a href="<%= request.getContextPath() %>/admin">⬅ Retour Admin</a>

</body>
</html>