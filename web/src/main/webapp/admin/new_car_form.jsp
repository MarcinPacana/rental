<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Nowe auto</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/new_car_form.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>

</head>
<body>
<jsp:include page="../fragments_jsp/admin_nav.jsp"/>
Nowe auto form

<div>
        <form action="createCar" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>Marka:</td>
                    <td><input  type="text" name="brand" size="20" /></td>
                </tr>
                <tr>
                    <td>Model:</td>
                    <td><input  type="text" name="model" size="20" /></td>
                </tr>
                <tr>
                    <td>Kolor:</td>
                    <td><input  type="text" name="color" size="20" /></td>
                </tr>
                <tr>
                    <td>Liczba siedzeń:</td>
                    <td><input  type="number" name="seats" /></td>
                </tr>
                <tr>
                    <td>Klimatyzacja:</td>
                    <td><input  type="text" name="airConditioning" size="20"/></td>
                </tr>
                <tr>
                    <td>Wielkość bagażnika [litry]:</td>
                    <td><input  type="number" name="trunkSize"  /></td>
                </tr>
                <tr>
                    <td>Liczba drzwi:</td>
                    <td><input  type="number" name="dors"  /></td>
                </tr>
                <tr>
                    <td>Skrzynia biegów:</td>
                    <td><input  type="text" name="gearBox"  /></td>
                </tr>
                <tr>
                    <td>Moc silnika:</td>
                    <td><input  type="number" name="enginePower"  /></td>
                </tr>
                <tr>
                    <td>Bazowa cena za dobe:</td>
                    <td><input  type="number" name="price"  /></td>
                </tr>

                <tr>
                    <td>Zdjęcie samochodu:</td>
                    <td>
                        <input id="carImage" type="file" name="image" size="20"/><br/>
                        <img id="thumbnail"  alt="Image Preview" style="width: 100px; height: 100px"/>
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

<script>
    $(document).ready(function () {
        $("#carImage").change(function () {
            showImageThumbnail(this);
        });
    });

    function showImageThumbnail(fileInput) {
        var file = fileInput.files[0];
        var reader = new FileReader();
        reader.onload = function (e) {
            $("#thumbnail").attr('src', e.target.result);
        };
        reader.readAsDataURL(file);
    }
</script>

</body>
</html>
