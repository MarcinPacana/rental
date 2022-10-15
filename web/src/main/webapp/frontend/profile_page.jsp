<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>CarRental - Customer Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/frontend/profile.css">
</head>
<body>
<jsp:include page="../fragments_jsp/main_nav.jsp" />
Moje konto

<table>
    <tr>
        <td><b>Data rejestracji:</b></td>
        <td>${sessionScope.loggedCustomer.registeredDate}</td>
    </tr>
    <tr>
        <td><b>Adres Email:</b></td>
        <td>${sessionScope.loggedCustomer.email}</td>
    </tr>
    <tr>
        <td><b>Imię:</b></td>
        <td>${sessionScope.loggedCustomer.firstName}</td>
    </tr>
    <tr>
        <td><b>Nazwisko:</b></td>
        <td>${sessionScope.loggedCustomer.lastName}</td>
    </tr>
    <tr>
        <td><b>Numer telefonu:</b></td>
        <td>${sessionScope.loggedCustomer.phoneNumber}</td>
    </tr>
    <tr>
        <td><b>Kraj:</b></td>
        <td>${sessionScope.loggedCustomer.country}</td>
    </tr>
    <tr>
        <td><b>Miasto:</b></td>
        <td>${sessionScope.loggedCustomer.city}</td>
    </tr>
    <tr>
        <td><b>Ulica:</b></td>
        <td>${sessionScope.loggedCustomer.street}</td>
    </tr>
    <tr>
        <td><b>Numer mieszkania:</b></td>
        <td>${sessionScope.loggedCustomer.flatNumber}</td>
    </tr>
    <tr>
        <td><b>Kod pocztowy:</b></td>
        <td>${sessionScope.loggedCustomer.zipCode}</td>
    </tr>

</table>

</body>
</html>