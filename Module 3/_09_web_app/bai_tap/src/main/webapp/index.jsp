<%--
  Created by IntelliJ IDEA.
  User: TuThinh
  Date: 26/10/2021
  Time: 3:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <form action="/index" method="post">
    <h3>Product Discount Calculator</h3>
    <label> Product Description:</label>
    <input type="text" name="txtMoTa" placeholder="Nhập mô tả sản phẩm"> <br>
    <label> List Price</label>
    <input type="text" name="txtGia" placeholder="Giá sản phẩm"><br>
    <label>Discount Percent</label>
    <input type="text" name="txtDiscount" placeholder="Nhập chiết khấu"> <br>
    <input type="submit" id="submit" value="Tính toán">


  </form>
  </body>
</html>
