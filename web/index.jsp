
<%--获取绝对路径--%>
<% String path=request.getContextPath()+"/";  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--  输入指定科目提交需求--%>
  <form action="<%=path%>single?method=getList" method="post">
    <input type="text" name="subject" value="">请输入科目
    <button type="submit">提交</button>
  </form>
<%--开始考试，跳转科目集jsp--%>
<form action="<%=path%>single?method=getSubjectList" method="post">
  <button type="submit">开始考试</button>
</form>

  </body>
</html>
