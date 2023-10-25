<%--
  Created by IntelliJ IDEA.
  User: mmish
  Date: 25.10.2023
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add car</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Add car</h1>
        <form method="post" action="addCarServlet">
            <div class="mb-3">
                <label class="form-label" for="model">Model</label>
                <input type="text" name="model" id="model" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label" for="manufacturer">Manufacturer</label>
                <input type="text" name="manufacturer" id="manufacturer" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label" for="engine">Engine volume</label>
                <input type="number" name="engine" id="engine" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label" for="year">Year production</label>
                <input type="text" name="year" id="year" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label" for="color">Color</label>
                <input type="text" name="color" id="color" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label" for="type">Car type</label>
                <input type="text" name="type" id="type" class="form-control">
            </div>
            <button class="btn btn-outline-success" type="submit">Send</button>
        </form>
    </div>
</body>
</html>
