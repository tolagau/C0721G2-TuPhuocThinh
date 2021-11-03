<%--
  Created by IntelliJ IDEA.
  User: TuThinh
  Date: 02/11/2021
  Time: 2:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Furama Resort</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
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
        <div class="col-lg-10">
            <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="https://danangfantasticity.com/wp-content/uploads/2021/02/Furama-resort-danang-103-105-vo-nguyen-giap-da-nang-fly-cam.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="https://bazantravel.com/cdn/medias/uploads/53/53114-furama-resort-da-nang-11.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="https://cdn1.ivivu.com/iVivu/2019/11/28/13/furama-resort-da-nang-1-cr-800x450.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
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
<script src="bootstrap/js/bootstrap.js"></script>
</html>