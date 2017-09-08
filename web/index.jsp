<%-- 
    Document   : index
    Created on : 2017/9/7, 上午 11:16:46
    Author     : Jimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="res/js/jquery.min.js"></script>
        <script src="res/js/config.js"></script>
        <script src="res/js/websocket.js"></script>
        <script src="res/js/main.js"></script>
    </head>
    <body>
        <h1>Spring MVC</h1>
        <a href="add.htm">新增資料</a>
        <a href="update.htm">更新資料</a>
        <a href="read.htm">讀取</a>
        <a href="showArray.htm">顯示陣列</a>
        <a href="setSession.htm">設定Session</a>
        <a href="getSession.htm">取得Session</a>
        <a href="test01.htm">HQL語句練習1</a>
        <a href="test02.htm">儲存會員</a>
        <input type="button" onclick="getData();" value="取資料">
        <hr>
        <form name="from" action="add.htm" method="post">
            <input name="data" type="text">
            <input type="submit" value="送出">
        </form>
    </body>
</html>