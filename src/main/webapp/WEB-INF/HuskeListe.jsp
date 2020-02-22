<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mozuh
  Date: 20-02-2020
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Webshop</title>
</head>
<body>

<h1>Du er nu klar til, at tilføje emner til din indkøbskurv.</h1>

<br>
<br>
${sessionScope.besked}

<br>
<br>

<form action="BuyServlet" method="post">
    <label for="fname">Skriv navn på vare</label><br>
    <input type="text" id="fname" name="vareNavn"><br>
    <br>
    <input type="submit" value="Tilføj">
</form>

<br>
<br>
<br>

${requestScope.besked}

<br>
<br>

<c:forEach var="element" items="${sessionScope.basket}">

    ${element}
    <br>

</c:forEach>

</body>
</html>
