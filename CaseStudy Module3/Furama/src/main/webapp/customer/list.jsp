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
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css"/>
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
                    <a class="nav-link dropdown-toggle" href="/employee" id="navbarDropdown-1" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Employee
                    </a>
                    <%--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown-1">--%>
                    <%--                        <li><a class="dropdown-item" href="/employee">List All</a></li>--%>
                    <%--                        <li><a class="dropdown-item" href="#">Create Employee</a></li>--%>

                    <%--                    </ul>--%>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-2" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Customer
                    </a>
                    <%--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown-2">--%>
                    <%--                        <li><a class="dropdown-item" href="#">List All</a></li>--%>
                    <%--                        <li><a class="dropdown-item" href="#">Create Customer</a></li>--%>
                    <%--                    </ul>--%>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-3" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Service
                    </a>
                    <%--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown-3">--%>
                    <%--                        <li><a class="dropdown-item" href="#">List All</a></li>--%>
                    <%--                        <li><a class="dropdown-item" href="#">Create Service</a></li>--%>
                    <%--                    </ul>--%>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-4" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Contract
                    </a>
                    <%--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown-4">--%>
                    <%--                        <li><a class="dropdown-item" href="#">List All</a></li>--%>
                    <%--                        <li><a class="dropdown-item" href="#">Create Contract</a></li>--%>
                    <%--                    </ul>--%>
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
            <a href="/customer?action"><p>List</p></a>
            <a href="/customer?action=create"><p>Create</p></a>
            <a href="/customer?action=update"><p>Update</p></a>
        </div>
        <div class="col-lg-10 ok">
            <div class="container">
                <h3>LIST OF FURAMA RESORT EMPLOYEE</h3>
                <table id="tableStudent" class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Loại khách hàng</th>
                        <th>Name</th>
                        <th>Birth Day</th>
                        <th>Giới tính</th>
                        <th>Id Card</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="customer" items="${customerList}">
                        <tr>
                            <td>${customer.getId()}</td>
                            <td>${customer.getCustomerType().getName()}</td>
                            <td>${customer.getName()}</td>
                            <td>${customer.getBirthday()}</td>
                            <td>${customer.getGender()}</td>
                            <td>${customer.getIdCard()}</td>
                            <td>${customer.getPhoneNum()}</td>
                            <td>${customer.getEmail()}</td>
                            <td>${customer.getAddress()}</td>
                            <td class="text-center">
                                <a href="/customer?action=update&id=${customer.getId()}" role="button"
                                   class="btn-warning">Edit</a>
                            </td>
                            <td>
                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                        data-target="#exampleModal-${customer.id}">
                                    Xóa
                                </button>
                            </td>
                                <%--                            <td><a href="home?notice=employee&note=edit&id=${employee.id}">Edit</a></td>--%>
                                <%--                            <td><a href="home?notice=delete&note=&id=${employee.id}">Delete</a></td>--%>
                        </tr>
                        <!-- Modal -->
                        <div class="modal fade" id="exampleModal-${customer.id}" tabindex="-1" role="dialog"
                             aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        Are you sure delete Employee có Id = ${customer.id} and Name
                                        là: ${customer.name}
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                                        </button>

                                        <a href="/customer?action=delete&id=${customer.id}" role="button"
                                           class="btn-danger">Đồng ý </a>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    </tbody>
                </table>
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

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

<script src="../bootstrap413/js/bootstrap.js"></script>
<%--<script src="../jquery/jquery-3.5.1.min.js"></script>--%>
<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>

<%--<script src="../DataTables/DataTables-1.11.3/js/jquery.dataTables.min.js"></script>--%>
<%--<script src="../DataTables/DataTables-1.11.3/js/dataTables.bootstrap5.js"></script>--%>
<%--<script src="../bootstrap/js/bootstrap.js"></script>--%>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</html>