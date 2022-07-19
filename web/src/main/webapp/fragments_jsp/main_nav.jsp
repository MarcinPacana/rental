<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Car Rental</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                <li class="nav-item">
                    <a class="nav-link active"  href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="">Car list</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">About Us</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link active" href="#"  >Contact</a>
                </li>
            </ul>

            <a href="${pageContext.request.contextPath}/login"><button type="button" class="btn btn-success">Log in</button></a>
            <a href="${pageContext.request.contextPath}/register"><button type="button me-2" class="btn btn-warning">Register</button></a>
        </div>
    </div>
</nav>