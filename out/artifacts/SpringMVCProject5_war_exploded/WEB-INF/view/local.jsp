<%--
  Created by IntelliJ IDEA.
  User: 12558
  Date: 14/08/2019
  Time: 00:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>local.jsp</title>
</head>
<body>
    <h1>local.jsp----国际化</h1>
    <a href="?language=zh_CN"><fmt:message key="language.cn"/></a>
    <a href="?language=en_US"><fmt:message key="language.en"/></a>
    <hr>
    <fmt:message key="welcome"/>
    <fmt:message key="name"/>
</body>
</html>
