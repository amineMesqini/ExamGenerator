<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Résultat</title>
</head>
<body>
    <h2>Examen terminé !</h2>
    
    <p>Votre note finale est de : <strong>${sessionScope.score}</strong> / ${sessionScope.questions.size()}</p>

    <a href="accueil.jsp">Retourner à la liste des examens</a>

    <% 
        // On nettoie la session pour éviter de rejouer l'examen avec le bouton retour du navigateur
        session.removeAttribute("questions");
        session.removeAttribute("currentIndex");
    %>
</body>
</html>