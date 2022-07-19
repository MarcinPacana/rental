<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CarRental - Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<jsp:include page="fragments_jsp/main_nav.jsp" />
<main class="form-signin">
    <form class="text-center" action="/register" method="post">

        <h1 class="h3 mb-3 fw-normal">Register</h1>


        <div class="form-floating">
            <input type="text" class="form-control" id="firstName">
            <label for="firstName">First Name</label>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control" id="lastName">
            <label for="lastName">Last Name</label>
        </div>
        <div class="form-floating">
            <input type="email" class="form-control" id="email" >
            <label for="email">Email</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="password">
            <label for="password">Password</label>
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign Up</button>
    </form>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>