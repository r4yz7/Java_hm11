<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Menu</h1>
        <a class="m-3 btn btn-outline-info" href="carsServlet">Show cars</a>
        <br>
        <a class="m-3 btn btn-outline-info" href="manufacturersServlet">Show manufacturers</a>
        <br>
        <a class="m-3 btn btn-outline-info" href="carCountServlet">Show count cars</a>
        <br>
        <a class="m-3 btn btn-outline-info" href="searchYearServlet">Show car by year</a>
        <br>
        <a class="m-3 btn btn-outline-info" href="carsByManufServlet">Show car by manufacturer</a>
        <br>
        <a class="m-3 btn btn-outline-info" href="addCarServlet">Add car</a>

    </div>
</body>
</html>