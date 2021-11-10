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
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
            <p>TỪ PHƯỚC THỊNH</p>
        </div>
    </div>

</div>
<%--<nav class="navbar navbar-expand-lg navbar-light bg-light">--%>
<%--    <div class="container-fluid">--%>
<%--        <a class="navbar-brand" href="#">Home</a>--%>
<%--        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"--%>
<%--                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--            <span class="navbar-toggler-icon"></span>--%>
<%--        </button>--%>
<%--        <div class="collapse navbar-collapse" id="navbarSupportedContent">--%>
<%--            <ul class="navbar-nav me-auto mb-2 mb-lg-0">--%>
<%--                <li class="nav-item dropdown">--%>
<%--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-1" role="button"--%>
<%--                       data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--                        Employee--%>
<%--                    </a>--%>
<%--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown-1">--%>
<%--                        <li><a class="dropdown-item" href="#">List All</a></li>--%>
<%--                        <li><a class="dropdown-item" href="#">Create Employee</a></li>--%>

<%--                    </ul>--%>
<%--                </li>--%>
<%--                <li class="nav-item dropdown">--%>
<%--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-2" role="button"--%>
<%--                       data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--                        Customer--%>
<%--                    </a>--%>
<%--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown-2">--%>
<%--                        <li><a class="dropdown-item" href="#">List All</a></li>--%>
<%--                        <li><a class="dropdown-item" href="#">Create Customer</a></li>--%>

<%--                    </ul>--%>
<%--                </li>--%>
<%--                <li class="nav-item dropdown">--%>
<%--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-3" role="button"--%>
<%--                       data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--                        Service--%>
<%--                    </a>--%>
<%--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown-3">--%>
<%--                        <li><a class="dropdown-item" href="#">List All</a></li>--%>
<%--                        <li><a class="dropdown-item" href="#">Create Service</a></li>--%>
<%--                    </ul>--%>
<%--                </li>--%>
<%--                <li class="nav-item dropdown">--%>
<%--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-4" role="button"--%>
<%--                       data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--                        Contract--%>
<%--                    </a>--%>
<%--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown-4">--%>
<%--                        <li><a class="dropdown-item" href="#">List All</a></li>--%>
<%--                        <li><a class="dropdown-item" href="#">Create Contract</a></li>--%>
<%--                    </ul>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--            <form class="d-flex">--%>
<%--                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--                <button class="btn btn-outline-success" type="submit">Search</button>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-2  m-auto p-1">
            <a href="#"><p>Create</p></a>
            <a href="#"><p>Display</p></a>
            <a href="#"><p>Search</p></a>
        </div>
        <div class="col-lg-10 ok">
            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12 text-center">
                            <h1>EDIT</h1>
                        </div>
                        <form class="col-12" method="post">
                            <div class="form-group col-12">
                                <label class="col-12 ">Id:</label>
                                <input type="text" name="id" class="form-control col-12  mt-2"
                                       value="${customer.getId()}" readonly>
                            </div>

                            <div class="form-group col-12">
                                <label class="" for="a">Diện tích:</label>
                                <input id="a" type="text" name="dientich" class="form-control col-12  mt-2"
                                       value="${customer.getName()}">

                                <%--                                <p style=" color: red">--%>
                                <%--                                    <c:if test='${idError != null}'>--%>
                                <%--                                        ${idError}--%>
                                <%--                                    </c:if>--%>
                                <%--                                </p>--%>

                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 float-left">Trạng thái:</label>
                                <input type="text" name="trangthai" class="form-control col-12  mt-2"
                                       value="${customer.getBirthDay()}">

                                <%--                                <p style=" color: red">--%>
                                <%--                                    <c:if test='${idError != null}'>--%>
                                <%--                                        ${idError}--%>
                                <%--                                    </c:if>--%>
                                <%--                                </p>--%>


                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 float-left">Tầng:</label>
                                <input type="text" name="tang" class="form-control col-12  mt-2"
                                       value="${customer.getGender()}">


                                <%--                                <p style=" color: red">--%>
                                <%--                                    <c:if test='${idError != null}'>--%>
                                <%--                                        ${idError}--%>
                                <%--                                    </c:if>--%>
                                <%--                                </p>--%>


                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 float-left">Loại mặt bằng:</label>
                                <select class="form-control" name="loai_mat_bang">
                                    <c:forEach var="type" items="${typeList}">
                                        <c:choose>
                                            <c:when test="${type.id == customer.getCustomerType().getId()}">
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
                                <label class="col-12 float-left">mô tả chi tiết:</label>
                                <input type="text" name="mota" class="form-control col-12  mt-2"
                                       value="${customer.getIdCard()}">

                                <%--                                <p style=" color: red">--%>
                                <%--                                    <c:if test='${idError != null}'>--%>
                                <%--                                        ${idError}--%>
                                <%--                                    </c:if>--%>
                                <%--                                </p>--%>


                            </div>

                            <div class="form-group col-12">
                                <label class="col-12 ">Giá cho thuê:</label>
                                <input type="text" name="gia" class="form-control col-12 fmt-2"
                                       value="${customer.getPhoneNum()}">

                                <%--                                <p style=" color: red">--%>
                                <%--                                    <c:if test='${idError != null}'>--%>
                                <%--                                        ${idError}--%>
                                <%--                                    </c:if>--%>
                                <%--                                </p>--%>


                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 ">Ngày bắt đầu:</label>
                                <input type="text" name="ngaybatdau" class="form-control col-12 fmt-2"
                                       value="${customer.getEmail()}">


                                <%--                                <p style=" color: red">--%>
                                <%--                                    <c:if test='${idError != null}'>--%>
                                <%--                                        ${idError}--%>
                                <%--                                    </c:if>--%>
                                <%--                                </p>--%>

                            </div>
                            <div class="form-group col-12">
                                <label class="col-12 ">Ngày kết thúc:</label>
                                <input type="text" name="ngayketthuc" class="form-control col-12 fmt-2"
                                       value="${customer.getAddress()}">

                                <%--                                <p style=" color: red">--%>
                                <%--                                    <c:if test='${idError != null}'>--%>
                                <%--                                        ${idError}--%>
                                <%--                                    </c:if>--%>
                                <%--                                </p>--%>


                            </div>

                            <button type="submit" class="btn btn-primary float-right">Edit</button>
                            <a href="/home">
                            <button type="button" class="btn btn-info float-right">Back</button>
                            </a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<div class="container-fluid bg-success m-auto text-light ">--%>
<%--    <div class="row">--%>
<%--        <div align="center">--%>
<%--            <p class="fs-6">Mọi nội dung tại đây © 2005 – 2021 Công ty TNHH Tư nhân Agoda. Bảo Lưu Mọi Quyền. Agoda.com--%>
<%--                là thành viên của Tập đoàn Booking Holdings, nhà cung cấp dịch vụ du lịch trực tuyến & các dịch--%>
<%--                vụ có liên quan hàng đầu thế giới.</p>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--</div>--%>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>

</html>