<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: TuThinh
  Date: 15/11/2021
  Time: 4:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form>
        <h1>Welcome</h1>
<%--        <h3>name: ${user.account}</h3>--%>
        <h3>Name: ${khaibao.name}</h3>
<%--        <h3>Email: ${user.email}</h3>--%>
<%--        <h3>Age: ${user.age}</h3>--%>
    </form>
</body>
</html>
