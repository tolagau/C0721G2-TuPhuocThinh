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
    <title>MẶT BẰNG</title>
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
            <p>Nguyễn Văn A</p>
        </div>
    </div>

</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-1  m-auto p-1">
            <a href="#"><p>Create</p></a>
            <a href="#"><p>Display</p></a>
            <a href="#"><p>Search</p></a>

        </div>
        <div class="col-6" align="right">
            <form method="post" action="/land?note=search">
                <input type="text" name="landTypeName" placeholder="Input landTypeName">
                <input type="text" name="price" placeholder="Input price ">
                <input type="text" name="floor" placeholder="Input floor">
                <button type="submit">TÌm kiếm</button>
            </form>
        </div>
        <div class="col-lg-10 ok">
            <div class="container">
                <h3>Danh sách sách</h3>
                <table id="tableStudent" class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>MÃ SÁCH</th>
                        <th>TÊN SÁCH</th>
                        <th>TÁC GIẢ</th>
                        <th>MÔ TẢ</th>
                        <th>SỐ LƯỢNG SÁCH</th>
                        <th>MƯỢN SÁCH</th>
<%--                        <th>Delete</th>--%>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="sach" items="${sachList}">
                        <tr>
                            <td>${sach.id}</td>
                            <td>${sach.name}</td>
                            <td>${sach.tacGia}</td>
                            <td>${sach.moTa}</td>
                            <td>${sach.soLuong}</td>
<%--                            <td>${land.moTa}</td>--%>
<%--                            <td>${land.gia}</td>--%>
<%--                            <td>${land.ngayDB}</td>--%>
<%--                            <td>${land.ngayKT}</td>--%>
                            <td class="text-center">
<%--                                <a href="/customer?action=update&id=${land.getId()}" role="button"--%>
                                <a href="/create.jsp" role="button"
                                   class="btn btn-large btn-warning">Mượn sách</a>
                            </td>
<%--                            <td>--%>
<%--                                <button type="button" class="btn btn-primary" data-toggle="modal"--%>
<%--                                        data-target="#exampleModal-${land.id}">--%>
<%--                                    Xóa--%>
<%--                                </button>--%>
<%--                            </td>--%>
                        </tr>

                        <!-- Modal -->
<%--                        <div class="modal fade" id="exampleModal-${land.id}" tabindex="-1" role="dialog"--%>
<%--                             aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--                            <div class="modal-dialog" role="document">--%>
<%--                                <div class="modal-content">--%>
<%--                                    <div class="modal-header">--%>
<%--                                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>--%>
<%--                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                                            <span aria-hidden="true">&times;</span>--%>
<%--                                        </button>--%>
<%--                                    </div>--%>
<%--                                    <div class="modal-body">--%>
<%--                                        Are you sure delete mặt bằng có Id = ${land.id} and diện tích--%>
<%--                                        là: ${land.dienTich}--%>
<%--                                    </div>--%>
<%--                                    <div class="modal-footer">--%>
<%--                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close--%>
<%--                                        </button>--%>

<%--                                        <a href="/matbang?note=delete&id=${land.id}" role="button"--%>
<%--                                           class="btn-danger">Đồng ý </a>--%>

<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<!--<div class="container-fluid bg-success m-auto text-light ">-->
<!--    <div class="row">-->
<!--        <div align="center">-->
<!--            <p class="fs-6">Mọi nội dung tại đây © 2005 – 2021 Công ty TNHH Tư nhân Agoda. Bảo Lưu Mọi Quyền. Agoda.com-->
<!--                là thành viên của Tập đoàn Booking Holdings, nhà cung cấp dịch vụ du lịch trực tuyến & các dịch-->
<!--                vụ có liên quan hàng đầu thế giới.</p>-->
<!--        </div>-->
<!--    </div>-->

<!--</div>-->

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