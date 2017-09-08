<%-- 
    Document   : showArray
    Created on : 2017/9/6, 下午 03:15:09
    Author     : Jimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            var ctx = "${pageContext.request.contextPath}";
            console.log(ctx);
        </script>
        <script src="res/js/main.js"></script>
    </head>
    <body>
        <script>
            showAlert();
        </script>
        <h1>資料迴圈產生</h1>    
        <c:forEach items="${datas}" var="data">
            <p>ID： <c:out value = "${data.id}"/></p>
            <p>資料： <c:out value = "${data.test}"/></p>
        </c:forEach>
        <h1>迴圈產生</h1>    
        <c:forEach var = "i" begin = "1" end = "5">
            <p>Item <c:out value = "${i}"/></p>
        </c:forEach>
    </body>
</html>
