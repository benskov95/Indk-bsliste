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
    <title>Johns Webshop!</title>
</head>
<body>

<h1>Du er nu klar til, og vil fortsætte med at være klar til, at tilføje emner til din gigafede indkøbskurv. Er du klar eller hvad?</h1>

<br>
<br>
${sessionScope.besked}

<br>
<br>

<form action="BuyServlet" method="post">
    <label for="fname">Skriv navn på vare, hvis du tør</label><br>
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

<br>
<br>
<br>

<form action="LogOutServlet" method="post">
    <input type="submit" value="Log ud">
</form>

</body>
</html>
