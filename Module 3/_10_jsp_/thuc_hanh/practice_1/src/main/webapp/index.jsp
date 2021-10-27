<%--
  Created by IntelliJ IDEA.
  User: TuThinh
  Date: 26/10/2021
  Time: 9:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>
  <h2>Currency Converter</h2>
  <form action="converter.jsp" method="post">
    <label>Rate:</label><br>
    <input type="text" name="rate" placeholder="RATE">
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="0">
    <input type="submit" value="Converter" id="submit">
  </form>
  </body>
</html>
