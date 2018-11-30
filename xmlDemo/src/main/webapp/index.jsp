<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<h2>Hello World!</h2>

<h2>你好</h2>

<div id="date"></div>
<script>
    var div = document.getElementById("date");
    div.innerHTML = new Date();
</script>
<h2>请输入一下内容：</h2>
<%--<form action="LoginServlet" method="post">--%>
<form action="cookie01" method="post">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>
    <input type="submit" name="login" value="登录">
</form>
</body>
</html>
