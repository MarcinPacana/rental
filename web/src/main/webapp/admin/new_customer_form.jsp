<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Nowe klient</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/new_car_form.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>

</head>
<body>
<jsp:include page="../fragments_jsp/admin_nav.jsp"/>
Nowe auto form

<div>
    <form action="createCustomer" method="post">
        <table>
            <tr>
                <td>Imię:</td>
                <td><input  type="text" name="firstName" size="20" /></td>
            </tr>
            <tr>
                <td>Nazwisko:</td>
                <td><input  type="text" name="lastName" size="20" required/></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input  type="email" name="email" size="20" required/></td>
            </tr>
            <tr>
                <td>Numer telefonu:</td>
                <td><input  type="number" name="phoneNumber" /></td>
            </tr>
            <tr>
                <td>Hasło:</td>
                <td><input  type="text" name="password" size="20"/></td>
            </tr>
            <tr>
                <td>Kraj:</td>
                <td><input  type="text" name="country"  /></td>
            </tr>
            <tr>
                <td>Miasto:</td>
                <td><input  type="text" name="city"  /></td>
            </tr>
            <tr>
                <td>Ulica:</td>
                <td><input  type="text" name="street"  /></td>
            </tr>
            <tr>
                <td>Numer mieszkania:</td>
                <td><input  type="text" name="flatNumber"  /></td>
            </tr>
            <tr>
                <td>Kod pocztowy:</td>
                <td><input  type="text" name="zipCode"  /></td>
            </tr>
            <tr>
                <td>Token:</td>
                <td><input  type="text" name="token"  /></td>
            </tr>

            <tr>
                <td>Konto aktywowane:</td>
                <td>
                    <input type="radio" id="tak" name="active" value="true">
                    <label for="tak">TAK</label><br>
                    <input type="radio" id="nie" name="active" value="false" checked>
                    <label for="nie">NIE</label><br>
                </td>
            </tr>


            <tr>
                <td>
                    <button type="submit">Zapisz</button>
                    <button type="button" id="buttonCancel">Anuluj</button>
                </td>
            </tr>

        </table>
    </form>

</div>
<script>

    $(document).ready(function () {
        $("#buttonCancel").click(function (){
            history.go(-1);
        });
    });

</script>

</body>
</html>
