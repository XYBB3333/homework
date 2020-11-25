<%@ page import="javax.xml.xpath.XPath" %><%--
  Created by IntelliJ IDEA.
  User: zyq914014125
  Date: 2020/11/2
  Time: 17:09
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
<form action="<%=path%>single?method=checkTest" method="post">
<%--    隐式提交科目名--%>
    <input type="hidden" name="paper" value="${paper}">
<%--    引入varStatus，用于表示当前指针的下标位置--%>
<c:forEach items="${list}" var="i" varStatus="var">
<%--试题输出--%>
    <p>${var.index}，${i.subject}</p>
    <p><input type="radio"  name="${var.index}" value="A">${i.option_A}</p>
    <p><input type="radio" name="${var.index}" value="B">${i.option_B}</p>
    <p><input type="radio" name="${var.index}" value="C">${i.option_C}</p>
      <p><input type="radio" name="${var.index}" value="D">${i.option_D}
    </p>
</c:forEach>
    <button type="submit">
        交卷
    </button>
</form>
</body>
</html>
