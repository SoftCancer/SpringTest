<%--
  Created by IntelliJ IDEA.
  User: ygxzz
  Date: 2018/11/9
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>jsp中的作用于：</h4>
<%

    pageContext.setAttribute("name","pageContext");
    request.setAttribute("name","request");
    session.setAttribute("name","session");
    application.setAttribute("name","application");
%>
<h4>jsp中的作用于的区别：</h4>

</body>
</html>
