<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mozuh
  Date: 20-02-2020
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>

<h1>Goddag admin.</h1>
<br>
Her kan du se og slette brugere.

<br>
<br>
<br>

<form action="AdminServlet" method="post">
    <label for="fname">Navn:</label><br>
    <input type="text" id="fname" name="navn"><br>
    ${requestScope.besked}
    <br>
    <input type="submit" value="Slet bruger">
</form>

<form action="AdminServlet" method="get">
    <input type="submit" value="Tilbage til forsiden">
</form>

<br>
<br>
<br>

<c:forEach var="element" items="${applicationScope.brugerMap}">

    ${element}
    <br>

</c:forEach>

</body>
</html>
