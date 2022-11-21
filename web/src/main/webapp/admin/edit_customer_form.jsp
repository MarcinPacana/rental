<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Edycja klienta</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/edit_customer_form.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>

</head>
<body>
<jsp:include page="../fragments_jsp/admin_nav.jsp"/>
Nowe auto form

<div>
    <form action="updateCustomer" method="post">
        <input type="hidden" name="id" value="${customer.id}">
        <table>
            <tr>
                <td>Imię:</td>
                <td><input  type="text" name="firstName" size="20" value="${customer.firstName}" /></td>
            </tr>
            <tr>
                <td>Nazwisko:</td>
                <td><input  type="text" name="lastName" size="20" value="${customer.lastName}" required/></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input  type="email" name="email" size="20" value="${customer.email}" required/></td>
            </tr>
            <tr>
                <td>Numer telefonu:</td>
                <td><input  type="number" name="phoneNumber" value="${customer.phoneNumber}" /></td>
            </tr>
            <tr>
                <td>Kraj:</td>
                <td><input  type="text" name="country" value="${customer.country}" /></td>
            </tr>
            <tr>
                <td>Miasto:</td>
                <td><input  type="text" name="city" value="${customer.city}" /></td>
            </tr>
            <tr>
                <td>Ulica:</td>
                <td><input  type="text" name="street" value="${customer.street}" /></td>
            </tr>
            <tr>
                <td>Numer mieszkania:</td>
                <td><input  type="text" name="flatNumber" value="${customer.flatNumber}" /></td>
            </tr>
            <tr>
                <td>Kod pocztowy:</td>
                <td><input  type="text" name="zipCode" value="${customer.zipCode}" /></td>
            </tr>
            <tr>
                <td>Token:</td>
                <td><input  type="text" name="token"  value="${customer.token}" /></td>
            </tr>

            <tr>
                <td>Konto aktywowane:</td>
                <td>
                    <c:if test="${customer.active == false}" >
                        <input type="radio" id="tak" name="active" value="true" >
                        <label for="tak">TAK</label><br>

                        <input type="radio" id="nie" name="active" value="false" checked>
                        <label for="nie">NIE</label><br>
                    </c:if>
                    <c:if test="${customer.active == true}" >
                        <input type="radio" id="tak" name="active" value="true" checked >
                        <label for="tak">TAK</label><br>

                        <input type="radio" id="nie" name="active" value="false" >
                        <label for="nie">NIE</label><br>
                    </c:if>
                </td>
            </tr>


            <tr>
                <td>
                    <button type="submit">Zapisz</button>
                </td>
            </tr>

        </table>
    </form>

</div>

</body>
</html>
