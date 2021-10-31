
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List by Search</title>
</head>
<body>
<p>
    <a href="/product">Back to product list</a>
</p>
<table border="1">
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Brand</th>
    </tr>
    <c:forEach items="${listProduct}" var="productObj">
        <tr>
            <td>${productObj.getId()}</td>
            <td>${productObj.getName()}</td>
            <td>${productObj.getPrice()}</td>
            <td>${productObj.getMoTa()}</td>
            <td>${productObj.getMake()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>