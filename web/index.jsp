<%--
  Created by IntelliJ IDEA.
  User: 12558
  Date: 11/08/2019
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
  <head>
    <title>index.jsp</title>
  </head>
  <body>
    <h1>index.jsp</h1>
    <a href="${pageContext.request.contextPath}/download/QQ图片20190403182418.jpg">下载图片1</a><br>
    <a href="${pageContext.request.contextPath}/download/QQ图片20181027204034.png">强人锁男</a><br>
  <hr>
    <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
        <%-- multipart/form-data: 不对字符编码。在使用包含文件上传控件的表单时，必须使用该值。--%>
        <input type="file" name="file"><br>
        <input type="submit" value="上传"><br>
    </form>
    <hr>
    <a href="${pageContext.request.contextPath}/exception">测试exception</a>
    <hr>
  <a href="${pageContext.request.contextPath}/local">测试本地化/国际化</a>
  </body>
</html>
