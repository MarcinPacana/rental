<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<header>
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/admin/listCustomer">Klienci</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/listReservation">Rezerwacje</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/listCar">Flota</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/finanse">Finanse</a></li>

            <c:choose>
                <c:when test="${sessionScope.loggedUser != null}">
                    ${sessionScope.loggedUser.firstName}
                    ${sessionScope.loggedUser.email}
                    <li><a href="#">MOJE KONTO</a> </li>
                    <li><a href="${pageContext.request.contextPath}/admin/logoutAdmin">Wyloguj</a> </li>
                </c:when>
            </c:choose>

        </ul>
    </nav>
</header>
