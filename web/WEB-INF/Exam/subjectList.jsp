<%--
  Created by IntelliJ IDEA.
  User: zyq914014125
  Date: 2020/11/2
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<% String path=request.getContextPath()+"/";  %>
<%--引入jstl标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=path%>single?method=getList" method="post">
<c:forEach items="${subjectList}" var="i">
<%-- 输出每个科目,讲每个科目绑定为提交按钮--%>
    <input type="submit" name="subject" value="${i}"></p>
</c:forEach>
</form>
</body>
</html>
