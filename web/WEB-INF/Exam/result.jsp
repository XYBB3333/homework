<%--
  Created by IntelliJ IDEA.
  User: zyq914014125
  Date: 2020/11/9
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%--引入jstl标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center><p>您的分数为：${score},正确率为${score}%</p>
<p>您的答案为：${userAnswerList}</p>
<p>正确答案为: ${answerList}</p></center>

</body>
</html>
