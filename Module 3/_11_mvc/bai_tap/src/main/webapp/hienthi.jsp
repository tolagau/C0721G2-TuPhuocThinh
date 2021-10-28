<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Products</h2>
<p>
    <a href="/product?productAction=create">Create new</a>
</p>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Decription</td>
        <td>Manufacture</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${listProduct}" var="productObj">
        <tr>
            <td>
                <a href="/listProduct?productAction=view&id=${productObj.getId()}">${productObj.getId()}</a>
            </td>
            <td>${productObj.getName}</td>
            <td><c:out value="${productObj.getPrice}"/></td>
            <td><c:out value="${productObj.getMota}"/></td>
            <td><c:out value="${productObj.getMake}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
