<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CarRental - Register</title>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/register.css">
</head>
<body>
<jsp:include page="fragments_jsp/main_nav.jsp" />
<main>
    REJESTRACJA
    <form action="register" method="post">
        <label for="email-input">Email </label>
        <input id="email-input" type="email" name="email">
        </br>
        <label for="firstName-input">Imie </label>
        <input id="firstName-input" type="text" name="firstName">
        </br>
        <label for="lastName-input">Nazwisko </label>
        <input id="lastName-input" type="text" name="lastName">
        </br>
        <label for="password-input">Haslo </label>
        <input id="password-input" type="password" name="password">
        </br>

        </br>
        <label for="country-input">Kraj </label>
        <input id="country-input" type="text" name="country">
        </br>
        </br>
        <label for="city-input">Miasto </label>
        <input id="city-input" type="text" name="city">
        </br>
        </br>
        <label for="street-input">Ulica </label>
        <input id="street-input" type="text" name="streat">
        </br>
        </br>
        <label for="flatNumber-input">Numer mieszkania </label>
        <input id="flatNumber-input" type="text" name="flatNumber">
        </br>
        </br>
        <label for="zipCode-input">Kod pocztowy </label>
        <input id="zipCode-input" type="number" name="zipCode">
        </br>

        <input type="submit" value="Zarejestruj">
    </form>

</main>

</body>
</html>