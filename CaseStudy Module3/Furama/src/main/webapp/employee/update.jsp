<%--
  Created by IntelliJ IDEA.
  User: TuThinh
  Date: 03/11/2021
  Time: 12:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Furama Resort</title>
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap.css">
    <style>
        * {
            margin: auto;
            padding: 0px 0px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-10">
            <img src="https://suno.vn/blog/wp-content/uploads/2014/12/nike-lich-su-thiet-ke-logo.jpg" width="7%">
        </div>
        <div class="col-lg-2">
            <p>Nguyễn Văn A</p>
        </div>
    </div>

</div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-1" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Employee
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown-1">
                        <li><a class="dropdown-item" href="#">List All</a></li>
                        <li><a class="dropdown-item" href="#">Create Employee</a></li>

                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-2" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Customer
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown-2">
                        <li><a class="dropdown-item" href="#">List All</a></li>
                        <li><a class="dropdown-item" href="#">Create Customer</a></li>

                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-3" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Service
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown-3">
                        <li><a class="dropdown-item" href="#">List All</a></li>
                        <li><a class="dropdown-item" href="#">Create Service</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-4" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Contract
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown-4">
                        <li><a class="dropdown-item" href="#">List All</a></li>
                        <li><a class="dropdown-item" href="#">Create Contract</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-2  m-auto p-1">
            <p>Item 1</p>
            <p>Item 2</p>
            <p>Item 3</p>
        </div>
        <div class="col-lg-10 ok">
            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12 text-center">
                            <h1>Edit Customer</h1>
                        </div>
                        <form class="col-12" method="post">
                            <div class="form-group col-12">
                                <label class="col-12 ">Id:</label>
                                <input type="text" name="id" class="form-control col-12  mt-2"
                                       value="${employee.getId()}" readonly>
                            </div>

                            <div class="form-group col-12">
                                <label class="" for="a">Name:</label>
                                <input id="a" type="text" name="name" class="form-control col-12  mt-2"
                                       value="${employee.getName()}">
                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 float-left">Birth Day:</label>
                                <input type="text" name="idCard" class="form-control col-12  mt-2"
                                       value="${employee.getBirthDay()}">
                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 float-left">Id Card:</label>
                                <input type="text" name="idCard" class="form-control col-12  mt-2"
                                       value="${employee.getIdCard()}">
                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 float-left">Salary:</label>
                                <input type="text" name="salary" class="form-control col-12  mt-2"
                                       value="${employee.getSalary()}">
                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 ">Phone:</label>
                                <input type="text" name="phone" class="form-control col-12 fmt-2"
                                       value="${employee.getPhone()}">
                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 ">Email:</label>
                                <input type="text" name="email" class="form-control col-12 fmt-2"
                                       value="${employee.getEmail()}">
                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 ">Address:</label>
                                <input type="text" name="address" class="form-control col-12 fmt-2"
                                       value="${employee.getAddress()}">
                            </div>


                            <div class="form-group col-12">
                                <label class="col-12 float-left">POSITION:</label>
                                <select class="form-control" name="position_id">
                                    <c:forEach var="type" items="${postitions}">
                                        <c:choose>
                                            <c:when test="${type.id == employee.getPosition().getId()}">
                                                <option value="${type.id}" selected> ${type.name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${type.id}">${type.name}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 float-left">EDUCATION
                                    DEGREE::</label>
                                <select class="form-control" name="education_degree_id">
                                    <c:forEach var="type" items="${eduList}">
                                        <c:choose>
                                            <c:when test="${type.id == employee.getEducationDegree().getId()}">
                                                <option value="${type.id}" selected> ${type.name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${type.id}">${type.name}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 float-left">DIVISION:</label>
                                <select class="form-control" name="division_id">
                                    <c:forEach var="type" items="${divisionList}">
                                        <c:choose>
                                            <c:when test="${type.id == employee.getDivision().getId()}">
                                                <option value="${type.id}" selected> ${type.name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${type.id}">${type.name}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>


                            <button type="submit" class="btn btn-primary float-right">Edit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid bg-success m-auto text-light ">
    <div class="row">
        <div align="center">
            <p class="fs-6">Mọi nội dung tại đây © 2005 – 2021 Công ty TNHH Tư nhân Agoda. Bảo Lưu Mọi Quyền. Agoda.com
                là thành viên của Tập đoàn Booking Holdings, nhà cung cấp dịch vụ du lịch trực tuyến & các dịch
                vụ có liên quan hàng đầu thế giới.</p>
        </div>
    </div>

</div>

</body>
<script src="../bootstrap/js/bootstrap.js"></script>
<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../bootstrap413/js/bootstrap.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap.min.js"></script>

</html>