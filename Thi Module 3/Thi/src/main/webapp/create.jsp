<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thi Module</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
            <img src="https://media-exp1.licdn.com/dms/image/C510BAQEdjKl11NB6-g/company-logo_200_200/0/1519959194921?e=2159024400&v=beta&t=DDGPgnMddsArR4oUVxPcRnCXjIm7LqkMtAWlBkTmL1Y"
                 width="4%">
        </div>
        <div class="col-lg-2">
            <p>TỪ PHƯỚC THỊNH</p>
        </div>
    </div>

</div>
<!--<nav class="navbar navbar-expand-lg navbar-light bg-light">-->
<!--    <div class="container-fluid">-->
<!--        <a class="navbar-brand" href="#">Home</a>-->
<!--        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"-->
<!--                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">-->
<!--            <span class="navbar-toggler-icon"></span>-->
<!--        </button>-->
<!--        <div class="collapse navbar-collapse" id="navbarSupportedContent">-->
<!--            <ul class="navbar-nav me-auto mb-2 mb-lg-0">-->
<!--                <li class="nav-item dropdown">-->
<!--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-1" role="button"-->
<!--                       data-bs-toggle="dropdown" aria-expanded="false">-->
<!--                        Employee-->
<!--                    </a>-->
<!--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown-1">-->
<!--                        <li><a class="dropdown-item" href="#">List All</a></li>-->
<!--                        <li><a class="dropdown-item" href="#">Create Employee</a></li>-->

<!--                    </ul>-->
<!--                </li>-->
<!--                <li class="nav-item dropdown">-->
<!--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-2" role="button"-->
<!--                       data-bs-toggle="dropdown" aria-expanded="false">-->
<!--                        Customer-->
<!--                    </a>-->
<!--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown-2">-->
<!--                        <li><a class="dropdown-item" href="#">List All</a></li>-->
<!--                        <li><a class="dropdown-item" href="#">Create Customer</a></li>-->

<!--                    </ul>-->
<!--                </li>-->
<!--                <li class="nav-item dropdown">-->
<!--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-3" role="button"-->
<!--                       data-bs-toggle="dropdown" aria-expanded="false">-->
<!--                        Service-->
<!--                    </a>-->
<!--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown-3">-->
<!--                        <li><a class="dropdown-item" href="#">List All</a></li>-->
<!--                        <li><a class="dropdown-item" href="#">Create Service</a></li>-->
<!--                    </ul>-->
<!--                </li>-->
<!--                <li class="nav-item dropdown">-->
<!--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown-4" role="button"-->
<!--                       data-bs-toggle="dropdown" aria-expanded="false">-->
<!--                        Contract-->
<!--                    </a>-->
<!--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown-4">-->
<!--                        <li><a class="dropdown-item" href="#">List All</a></li>-->
<!--                        <li><a class="dropdown-item" href="#">Create Contract</a></li>-->
<!--                    </ul>-->
<!--                </li>-->
<!--            </ul>-->
<!--            <form class="d-flex">-->
<!--                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">-->
<!--                <button class="btn btn-outline-success" type="submit">Search</button>-->
<!--            </form>-->
<!--        </div>-->
<!--    </div>-->
<!--</nav>-->

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-1  m-auto p-1">
            <a href="#"><p>Create</p></a>
            <a href="#"><p>Display</p></a>
            <a href="#"><p>Search</p></a>
        </div>

        <div class="col-lg-10">
            <div class="container-fluid">
                <h3>THÊM MỚI MẶT BẰNG</h3>
                <div>
                    <form class="col-10  m-auto " method="post">
                        <div class="form-group col-12 ">
                            <label class="col-12 float-left" for="exampleInputMA">Mã mượn sách:</label>
                            <input type="text" name="id" class="form-control col-12 float-left mt-2"
                                   id="exampleInputMA" placeholder="Enter id">

                            <%--                            <p style=" color: red">--%>
                            <%--                                <c:if test='${idError != null}'>--%>
                            <%--                                    ${idError}--%>
                            <%--                                </c:if>--%>
                            <%--                            </p>--%>

                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-1" for="exampleInputPosition">Tên sách:</label>
                            <select name="tenSach" id="exampleInputTenSach"
                                    class="form-control col-12 float-left">
                                <option>Chose option ...</option>
                                <c:forEach var="item" items="${sachList}">
                                    <option value="${item.getId()}"> ${item.getId()} - ${item.getName()} </option>
                                </c:forEach>
                            </select>
                        </div>

                        <%--                        <div class="form-group col-12">--%>
                        <%--                            <label class="col-12 float-left" for="exampleInputAREA">Tên sách:</label>--%>
                        <%--                            <input type="text" name="dientich" class="form-control col-12 float-left mt-2"--%>
                        <%--                                   id="exampleInputAREA" placeholder="Enter Area">--%>

                        <%--&lt;%&ndash;                            <p style=" color: red">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;                                <c:if test='${idError != null}'>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;                                    ${idError}&ndash;%&gt;--%>
                        <%--&lt;%&ndash;                                </c:if>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;                            </p>&ndash;%&gt;--%>

                        <%--                        </div>--%>

                        <%--                        <div class="form-group col-12">--%>
                        <%--                            <label class="col-12 float-left" for="exampleInputTRANGTHAI">TRANG THÁI:</label>--%>
                        <%--                            <input type="text" name="trangthai" class="form-control col-12 float-left mt-2"--%>
                        <%--                                   id="exampleInputTRANGTHAI" placeholder="Enter Status">--%>

                        <%--                        </div>--%>

                        <%--                        <div class="form-group col-12">--%>
                        <%--                            <label class="col-12 float-left" for="exampleInputTANG">Tầng:</label>--%>
                        <%--                            <input type="text" name="tang" class="form-control col-12 float-left mt-2"--%>
                        <%--                                   id="exampleInputTANG" placeholder="Enter Area">--%>

                        <%--&lt;%&ndash;                            <p style=" color: red">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;                                <c:if test='${idError != null}'>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;                                    ${idError}&ndash;%&gt;--%>
                        <%--&lt;%&ndash;                                </c:if>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;                            </p>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;                            &ndash;%&gt;--%>
                        <%--                        </div>--%>

                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-1" for="exampleInputPosition">Tên học sinh:</label>
                            <select name="tenHocSinh" id="exampleInputPosition"
                                    class="form-control col-12 float-left">
                                <option>Chose option ...</option>
                                <c:forEach var="item" items="${hocSinhList}">
                                    <option value="${item.getId()}"> ${item.getId()} - ${item.getName()} </option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputVao">Ngày mượn:</label>
                            <input type="date" name="ngaymuon" class="form-control col-12 float-left mt-2"
                                   id="exampleInputVao" placeholder="Enter mô tả">

                            <%--                            <p style=" color: red">--%>
                            <%--                                <c:if test='${idError != null}'>--%>
                            <%--                                    ${idError}--%>
                            <%--                                </c:if>--%>
                            <%--                            </p>--%>

                        </div>

                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInputRa">Ngày trả:</label>
                            <input type="date" name="ngaytra" class="form-control col-12 float-left mt-2"
                                   id="exampleInputRa" placeholder="Enter price">

                            <%--                            <p style=" color: red">--%>
                            <%--                                <c:if test='${idError != null}'>--%>
                            <%--                                    ${idError}--%>
                            <%--                                </c:if>--%>
                            <%--                            </p>--%>

                        </div>


                        <button type="submit" class="btn btn-primary float-right">Mượn sách</button>
                        <a href="/home">
                            <button type="button" class="btn btn-info float-right">Back</button>
                        </a>
                    </form>
                </div>
            </div>
        </div>
        <!--        <div class="container-fluid bg-success m-auto text-light ">-->
        <!--            <div class="row">-->
        <!--                <div align="center">-->
        <!--                    <p class="fs-6">Mọi nội dung tại đây © 2005 – 2021 Công ty TNHH Tư nhân Agoda. Bảo Lưu Mọi Quyền.-->
        <!--                        Agoda.com-->
        <!--                        là thành viên của Tập đoàn Booking Holdings, nhà cung cấp dịch vụ du lịch trực tuyến & các dịch-->
        <!--                        vụ có liên quan hàng đầu thế giới.</p>-->
        <!--                </div>-->
        <!--            </div>-->

        <!--        </div>-->
    </div>
</div>

</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</html>