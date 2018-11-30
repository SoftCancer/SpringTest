<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: ygxzz
  Date: 2018/11/9
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>您的购物车的商品如下：</h3>
<%
    Map<String, Integer> map = (Map<String, Integer>) request.getSession().getAttribute("Cart");
    if (map != null) {
        for (String s : map.keySet()) {
            Integer value = map.get(s);
%>
    <h3>商品名称:<%= s %>  商品数量:<%= value%></h3>

<%
        }
    }
%>
<br>
<a href="clearCart"><h3>清空购物车</h3></a>
</body>
</html>
