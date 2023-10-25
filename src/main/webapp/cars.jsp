<%--
  Created by IntelliJ IDEA.
  User: mmish
  Date: 23.10.2023
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Model</th>
            <th>Manufacturer</th>
            <th>Engine volume</th>
            <th>Year production</th>
            <th>Color</th>
            <th>Car Type</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="car" items="${cars}">
            <tr>
                <td>${car.id}</td>
                <td>${car.model}</td>
                <td>${car.manufacturer}</td>
                <td>${car.engineVolume}</td>
                <td>${car.yearProduction}</td>
                <td>${car.color}</td>
                <td>${car.carType}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="index.jsp" class="btn btn-outline-info">Back</a>
</div>
</body>
</html>
