<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Ajouter Question</title>

    <script>
        function toggleOptions() {
            const type = document.getElementById("typeQuestion").value;
            const optionsDiv = document.getElementById("optionsBlock");

            if (type === "QCM") {
                optionsDiv.style.display = "block";
            } else {
                optionsDiv.style.display = "none";
            }
        }
    </script>

</head>
<body>

<h2>Ajouter une Question</h2>

<form action="${pageContext.request.contextPath}/addQuestion" method="post">

    <input type="hidden" name="examId" value="1">

    Question:<br>
    <textarea name="contenu" required></textarea><br><br>

    Type:
    <select name="typeQuestion" id="typeQuestion" onchange="toggleOptions()">
        <option value="QCM">QCM</option>
        <option value="TEXTE_A_TROUS">Texte à trous</option>
        <option value="COURTE_REPONSE">Courte réponse</option>
    </select>
    <br><br>

    Points:
    <input type="number" name="points" value="1" required>
    <br><br>

    <!-- Options QCM -->
    <div id="optionsBlock">

        Option 1:
        <input type="text" name="options"><br>
        <input type="radio" name="correctOption" value="0"> Correct<br><br>

        Option 2:
        <input type="text" name="options"><br>
        <input type="radio" name="correctOption" value="1"> Correct<br><br>

        Option 3:
        <input type="text" name="options"><br>
        <input type="radio" name="correctOption" value="2"> Correct<br><br>

        Option 4:
        <input type="text" name="options"><br>
        <input type="radio" name="correctOption" value="3"> Correct<br><br>

    </div>

    <button type="submit">Ajouter</button>

</form>

<script>
    toggleOptions();
</script>

</body>
</html>