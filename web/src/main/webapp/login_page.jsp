<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CarRental - Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<jsp:include page="fragments_jsp/main_nav.jsp" />

<main class="form-signin">


    <form class="text-center" action="/login" method="post">

        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

        <div class="form-floating">
            <input type="email" class="form-control" id="email" name="email">
            <label for="email">Email address</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="password" name="password">
            <label for="password">Password</label>
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
    </form>
</main>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>