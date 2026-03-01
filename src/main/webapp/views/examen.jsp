<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Examen</title>
    <script>
        // Logique : Chronomètre
        let temps = 300; // 5 minutes
        function startTimer() {
            const timerElement = document.getElementById('timer');
            const interval = setInterval(() => {
                let mins = Math.floor(temps / 60);
                let secs = temps % 60;
                timerElement.innerText = mins + ":" + (secs < 10 ? '0' : '') + secs;
                if (temps <= 0) {
                    clearInterval(interval);
                    document.getElementById('examForm').submit();
                }
                temps--;
            }, 1000);
        }
    </script>
</head>
<body onload="startTimer()">
    <h1>Examen en cours</h1>
    <div id="timer" style="font-size: 20px; color: red;"></div>

    <form id="examForm" action="passerExamen" method="post">
        <h3>${question.enonce}</h3>
        
        <c:forEach var="opt" items="${question.options}">
            <input type="radio" name="reponse" value="${opt.id}" required> ${opt.libelle} <br>
        </c:forEach>

        <br>
        <button type="submit">Valider et Suivant</button>
    </form>
</body>
</html>