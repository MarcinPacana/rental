<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Edycja samochodu</title>


    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>

</head>
<body>
Edycja samochodu

<div>
    <form action="updateCar" method="post" enctype="multipart/form-data">
        <input type="number" name="id" value="${car.id}" hidden />
        <table>
            <tr>
                <td>ID:</td>
               <td>
                   <input type="number" name="disabled" value="${car.id}" disabled />
               </td>
            </tr>
            <tr>
                <td>Marka:</td>
                <td><input  type="text" name="brand" size="20" value="${car.brand}" required/></td>
            </tr>
            <tr>
                <td>Model:</td>
                <td><input  type="text" name="model" size="20" value="${car.model}" required/></td>
            </tr>
            <tr>
                <td>Kolor:</td>
                <td><input  type="text" name="color" size="20" value="${car.color}" required /></td>
            </tr>
            <tr>
                <td>Liczba siedzeń:</td>
                <td><input  type="number" name="seats" size="20" value="${car.seats}" required /></td>
            </tr>
            <tr>
                <td>Klimatyzacja:</td>
                <td><input  type="text" name="airConditioning" size="20" value="${car.stringAirConditioning}" required /></td>
            </tr>
            <tr>
                <td>Wielkość bagażnika [litry]:</td>
                <td><input  type="number" name="trunkSize"  value="${car.trunkSize}" required /></td>
            </tr>
            <tr>
                <td>Liczba drzwi:</td>
                <td><input  type="number" name="dors"  value="${car.dors}" required /></td>
            </tr>
            <tr>
                <td>Skrzynia biegów:</td>
                <td><input  type="text" name="gearBox"  value="${car.gearBox}" required /></td>
            </tr>
            <tr>
                <td>Moc silnika:</td>
                <td><input  type="number" name="enginePower"  value="${car.enginePower}" required /></td>
            </tr>
            <tr>
                <td>Bazowa cena za dobe:</td>
                <td><input  type="number" name="price"  value="${car.price}" required /></td>
            </tr>

            <tr>
                <td>Zdjęcie samochodu: </td>
                <td>
                    <input id="carImage" type="file" name="image" size="20" />
                    <br/>
                    <img id="thumbnail"  alt="Image Preview" style="width: 100px; height: 100px"
                         src="data:image/jpg;base64,${car.imageBase64}"/>
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
