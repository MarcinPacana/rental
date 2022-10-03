<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CarRental - Login</title>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<jsp:include page="fragments_jsp/main_nav.jsp" />
<main>
    <h3>LOGOWANIE</h3>
    <div>
        <form action="login" method="post">
            <label for="email-input">email: </label>
            <input id="email-input" type="email" name="email">
                </br>
            <label for="password-input">password: </label>
            <input id="password-input" type="password" name="password">
                </br>
            <input type="submit" value="Zaloguj">
        </form>
    </div>

</main>
</body>
</html>