<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Admin - Lista klientów</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/customer_list.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="../fragments_jsp/admin_nav.jsp" />
Lista klientów

<c:if test="${message != null}">
    <div>
        <h4>${message}</h4>
    </div>
</c:if>

<h3><a href="newCustomer">Stwórz nowego klienta</a></h3>

<div>
    <table>
        <tr>
            <th>Index</th>
            <th>Id</th>
            <th>Email</th>
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Numer telefonu</th>
            <th>Data rejestracji</th>
            <th>Państwo</th>
            <th>Miasto</th>
            <th>Ulica</th>
            <th>Numer mieszkania</th>
            <th>Kod pocztowy</th>
            <th>Token</th>
            <th>Konto aktywne</th>
        </tr>
        <c:forEach var="customer" items="${customerList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${customer.id}</td>
                <td>${customer.email}</td>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.phoneNumber}</td>
                <td>${customer.registeredDate}</td>
                <td>${customer.country}</td>
                <td>${customer.city}</td>
                <td>${customer.street}</td>
                <td>${customer.flatNumber}</td>
                <td>${customer.zipCode}</td>
                <td>${customer.token}</td>
                <td>${customer.active}</td>

                <td>
                    <a href="editCustomer?id=${customer.id}">Edytuj</a> &nbsp
                    <form action="deleteCustomer" method="post">
                        <input type="hidden" name="id" value="${customer.id}" />
                        <button type="submit">Usuń</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>
