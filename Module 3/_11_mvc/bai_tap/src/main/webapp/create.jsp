<%--
  Created by IntelliJ IDEA.
  User: TuThinh
  Date: 28/10/2021
  Time: 5:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Create Product</h1>
    <p>
        <c:if test="${message != null} ">
            <span class="message"> ${message}</span>
        </c:if>
    </p>
    <p>
        <a href="/product">Back to product list</a>
    </p>
    <form action="" method="post">
        <fieldset>
            <table>
                <tr>
                    <td>Id:</td>
                    <td><input type="text" name="id" id="id"></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="text" name="price" id="price"></td>
                </tr>
                <tr>
                    <td>Mota:</td>
                    <td><input type="text" name="description" id="description"></td>
                </tr>
                <tr>
                    <td>Brand:</td>
                    <td><input type="text" name="brand" id="brand"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create product"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
