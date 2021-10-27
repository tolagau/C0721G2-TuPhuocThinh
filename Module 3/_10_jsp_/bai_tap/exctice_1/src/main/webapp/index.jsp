<%--
  Created by IntelliJ IDEA.
  User: TuThinh
  Date: 27/10/2021
  Time: 1:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Hiển thị</title>
  </head>
  <body>
    <h2>Customer List</h2>
    <table border="1">
      <tr>
        <th>No</th>
        <th>Name</th>
        <th>Day of birth</th>
        <th>Address</th>
        <th>Img</th>
      </tr>
      <c:forEach var="customerObj" items="${displayCus}" varStatus="loop">
      <tr>
        <td>${loop.count}</td>
        <td><c:out value="${customerObj.nameCus}"/></td>
        <td><c:out value="${customerObj.dateOfBirth}"/></td>
        <td><c:out value="${customerObj.addr}"/></td>
        <td><img src="<c:out value="${customerObj.img}"/>" width="200px"></td>
      </tr>
      </c:forEach>
    </table>



  </body>
</html>
