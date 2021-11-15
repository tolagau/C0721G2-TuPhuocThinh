<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>KHAI BÁO Y TẾ</h3>

<form:form action="/home" method="post" modelAttribute="khaibao">
    <fieldset>
        <legend>Khai báo y tế</legend>
        <table>
            <tr>
                <td><form:label path="name">Name:</form:label></td>
                <td><form:input path="name"/></td>
            </tr>

            <tr>
                <td><form:label path="dateOfBirth">Ngày sinh:</form:label></td>
                <td><form:input path="dateOfBirth"/></td>
            </tr>
            <tr>
                <td><form:label path="gender">gioi tinh:</form:label></td>
                    <%--                <td><form:select path="gender" items="${genders}"/></td>--%>
                <td><form:select path="gender">
                    <form:options items="${genders}"/>
                </form:select></td>
            </tr>

            <tr>
                <td><form:label path="quocTich">Quốc tịch:</form:label></td>
                <td><form:input path="quocTich"/></td>
            </tr>

            <tr>
                <td><form:label path="idCard">CMND/CCCD:</form:label></td>
                <td><form:input path="idCard"/></td>
            </tr>
            address
            <tr>
                <td><form:label path="address">Địa chỉ:</form:label></td>
                <td><form:input path="address"/></td>
            </tr>
            <tr>
                <td></td>
                <td><form:button>Login</form:button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>