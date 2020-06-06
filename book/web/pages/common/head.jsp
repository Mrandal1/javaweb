<%--
  Created by IntelliJ IDEA.
  User: 11607
  Date: 2020/6/6
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--动态Base--%>
<%
    String ServerPath = request.getScheme() +
            "://" +
            request.getServerName() +
            ":"+
            request.getServerPort()+
            request.getContextPath()+
            "/";
%>

<base href=<%=ServerPath%>>
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script src="static/scripts/jquery-3.4.1.js"></script>
