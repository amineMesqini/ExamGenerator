<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Connexion</h2>

<form action="${pageContext.request.contextPath}/login" method="post">
    Email: <input type="text" name="email"><br><br>
    Password: <input type="password" name="password"><br><br>
    <button type="submit">Se connecter</button>
</form>

</body>
</html>