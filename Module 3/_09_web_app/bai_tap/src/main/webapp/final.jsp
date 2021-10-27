
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<label>Discount Amount:</label>
<h2>
    <%=request.getAttribute("resulFromServlet")%>
</h2>
<label>Discount Price:</label>
<h2>
    <%=request.getAttribute("resulFromServlet1")%>
</h2>

</body>
</html>
