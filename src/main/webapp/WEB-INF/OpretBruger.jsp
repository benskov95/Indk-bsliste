<%--
  Created by IntelliJ IDEA.
  User: mozuh
  Date: 20-02-2020
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ny Bruger</title>
</head>
<body>

Inden du kan købe ting på webshoppen, skal du først registrere dig som bruger.
<br>
<br>
<br>

<form action="OpretServlet" method="post">
    <label for="fname">Navn:</label><br>
    <input type="text" id="fname" name="navn"><br>
    <label for="lname">Kodeord:</label><br>
    <input type="text" id="lname" name="kodeord"><br><br>
    ${requestScope.besked}
    <br>
    <input type="submit" value="Opret">
</form>

</body>
</html>
