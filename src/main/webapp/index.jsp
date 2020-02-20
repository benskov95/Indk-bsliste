<%--
  Created by IntelliJ IDEA.
  User: mozuh
  Date: 20-02-2020
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginServlet</title>
</head>
<body>
Velkommen til din online indkøbsliste.




<form action="LoginServlet" method="post">
    <label for="fname">Navn:</label><br>
    <input type="text" id="fname" name="Navn"><br>
    <label for="lname">Kodeord:</label><br>
    <input type="text" id="lname" name="Kodeord"><br><br>
    <input type="submit" value="Log ind">
</form>


</body>
</html>
