<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<header>
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}">Home</a></li>
            <li><a href="car_list">Oferta</a></li>
            <li><a href="contact">Kontakt</a></li>
            <c:choose>
                <c:when test="${sessionScope.loggedCustomer != null}">
                    ${sessionScope.loggedCustomer.firstName}
                    ${sessionScope.loggedCustomer.email}
                    <li><a href="profile">MOJE KONTO</a> </li>
                    <li><a href="logout">Wyloguj</a> </li>
                </c:when>
                <c:otherwise>
                    <li><a href="login">Logowanie</a></li>
                    <li><a href="register">Rejestracja</a></li>
                </c:otherwise>
            </c:choose>

        </ul>
    </nav>
</header>
