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
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="../DataTables/DataTables-1.11.3/css/dataTables.bootstrap5.css">
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
        <div class="col-lg-2 ">
            <p>Item 1</p>
            <p>Item 2</p>
            <p>Item 3</p>
        </div>
        <div class="col-lg-10 ">
            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12 text-center">
                            <h1>CREATE EMPLOYEE</h1>
                        </div>
                        <c:if test='${requestScope["message"] != null}'>
                            <span class="col-12 border bg-light">${requestScope["message"]}</span>
                        </c:if>
                        <form class="col-12" method="post">
<%--                            <div class="form-group col-12">--%>
<%--                                <label class="col-12 float-left" for="exampleInputID">Employee ID:</label>--%>
<%--                                <input type="text" name="id" class="form-control col-12 float-left mt-2"--%>
<%--                                       id="exampleInputID" placeholder="Enter ID">--%>
<%--                            </div>--%>

                            <div class="form-group col-12">
                                <label class="col-12 float-left" for="exampleInputName">Name Employee:</label>
                                <input type="text" name="name" class="form-control col-12 float-left mt-2"
                                       id="exampleInputName" placeholder="Enter Name">
                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 float-left" for="exampleInputBirthday">Birthday:</label>
                                <input type="text" name="birthday" class="form-control col-12 float-left mt-2"
                                       id="exampleInputBirthday" placeholder="Enter Birth Day">
                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 float-left" for="exampleInputIDCARD">IDCARD:</label>
                                <input type="text" name="idCard" class="form-control col-12 float-left mt-2"
                                       id="exampleInputIDCARD" placeholder="Enter ID CARD">
                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 float-left" for="exampleInputSALARY">SALARY:</label>
                                <input type="text" name="salary" class="form-control col-12 float-left mt-2"
                                       id="exampleInputSALARY" placeholder="Enter SALARY">
                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 float-left" for="exampleInputPHONE">PHONE:</label>
                                <input type="text" name="phone" class="form-control col-12 float-left mt-2"
                                       id="exampleInputPHONE" placeholder="Enter PHONE">
                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 float-left" for="exampleInputEMAIL">EMAIL:</label>
                                <input type="text" name="email" class="form-control col-12 float-left mt-2"
                                       id="exampleInputEMAIL" placeholder="Enter EMAIL">
                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 float-left" for="exampleInputADDRESS">ADDRESS:</label>
                                <input type="text" name="address" class="form-control col-12 float-left mt-2"
                                       id="exampleInputADDRESS" placeholder="Enter ADDRESS">
                            </div>

                            <div class="form-group col-12">
                                <label class="col-12 float-left mt-1" for="exampleInputPosition">POSITION:</label>
                                <select name="position_id" id="exampleInputPosition"
                                        class="form-control col-12 float-left">
                                    <option>Chose option ...</option>
                                    <c:forEach var="item" items="${postitions}">
                                        <option value="${item.getId()}"> ${item.getId()} - ${item.getName()} </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group col-12">
                                <label class="col-12 float-left mt-1" for="exampleInputEducationDegree">EDUCATION
                                    DEGREE:</label>
                                <select name="education_degree_id" id="exampleInputEducationDegree"
                                        class="form-control col-12 float-left">
                                    <option>Chose option ...</option>
                                    <c:forEach var="item" items="${eduList}">
                                        <option value="${item.getId()}"> ${item.getId()} - ${item.getName()} </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group col-12">
                                <label class="col-12 float-left mt-1" for="exampleInputDivision">DIVISION:</label>
                                <select name="division_id" id="exampleInputDivision"
                                        class="form-control col-12 float-left">
                                    <option>Chose option ...</option>
                                    <c:forEach var="item" items="${divisionList}">
                                        <option value="${item.getId()}"> ${item.getId()} - ${item.getName()} </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <button type="submit" class="btn btn-primary float-right">Create</button>
                            <a href="">
                                <button type="button" class="btn btn-info float-right">Back</button>
                            </a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid bg-success m-auto text-light ">
            <div class="row">
                <div align="center">
                    <p class="fs-6">Mọi nội dung tại đây © 2005 – 2021 Công ty TNHH Tư nhân Agoda. Bảo Lưu Mọi Quyền.
                        Agoda.com
                        là thành viên của Tập đoàn Booking Holdings, nhà cung cấp dịch vụ du lịch trực tuyến & các dịch
                        vụ có liên quan hàng đầu thế giới.</p>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
<script src="../bootstrap/js/bootstrap.js"></script>
<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../DataTables/DataTables-1.11.3/js/jquery.dataTables.min.js"></script>
<script src="../DataTables/DataTables-1.11.3/js/dataTables.bootstrap5.js"></script>

</html>