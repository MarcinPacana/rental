<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CarRental - Car list</title>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/car_list.css">

    <script src="../js/main.js"></script>

</head>
<body>
<jsp:include page="../fragments_jsp/main_nav.jsp" />
Oferta


<div>
    <table>
        <tr>
            <th>Index</th>
            <th>Zdjecie</th>
            <th>Id</th>
            <th>Marka</th>
            <th>Model</th>
            <th>Kolor</th>
            <th>Ilość siedzień</th>
            <th>Klimatyzacja</th>
            <th>Wielkość bagażnika</th>
            <th>Drzwi</th>
            <th>Skrzynia biegów</th>
            <th>Moc silnika</th>
            <th>Cena bazowa</th>
            <th></th>

        </tr>
        <c:forEach var="car" items="${carList}" varStatus="status">
            <tr>
                <th>${status.index + 1}</th>
                <td>
                    <img src="data:image/jpg;base64,${car.imageBase64}" width="84" height="110"/>
                </td>
                <th>${car.id}</th>
                <th>${car.brand}</th>
                <th>${car.model}</th>
                <th>${car.color}</th>
                <th>${car.seats}</th>
                <th>${car.stringAirConditioning}</th>
                <th>${car.trunkSize}</th>
                <th>${car.dors}</th>
                <th>${car.gearBox}</th>
                <th>${car.enginePower}</th>
                <th>${car.price}</th>
                <td>
                    <a href="car?id=${car.id}">Szczegóły</a> &nbsp;
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
