<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Strona logowania</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

</head>
<body>
Admin login

<form action="loginAdmin" method="post">
    <table>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" id="email" size="20"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td>
                <button type="submit">Login</button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
