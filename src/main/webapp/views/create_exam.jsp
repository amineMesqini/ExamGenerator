<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Créer un examen</title>
</head>
<body>

<h2>Créer un examen</h2>

<form action="${pageContext.request.contextPath}/createExam" method="post">



    Titre : <input type="text" name="titre">
    <textarea name="description"></textarea>
    Durée (minutes): <input type="number" name="dureeMinutes">



    <button type="submit">Créer</button>
</form>

</body>
</html>