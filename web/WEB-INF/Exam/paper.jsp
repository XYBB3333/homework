<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--获取静态上下文--%>
<%
	String path = request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="js/jquery.js"></script>
</head>
<body>
	<h3>考试</h3>
	<form action="questionServlet">
		<input type="hidden" name="method" value="submitPaper"> <input
			type="hidden" name="paper" value="${param.paper }">
<%--		c:forEach表示对指定对象的循环遍历，参数为${后端指定的key}，
var等同于java增强for循环的Key,即指针--%>
		<c:forEach items="${list}" var="single" varStatus="status">
			<p>${status.count}、${single.subject }</p>
			<p>
<%--				取出list列表中的当前指针的成员变量--%>
				<input type="radio" name="answer${status.index}" value="A">A.${single.option_A }
			</p>
			<p>
				<input type="radio" name="answer${status.index}" value="B">B.${single.option_B }
			</p>
			<p>
				<input type="radio" name="answer${status.index}" value="C">C.${single.option_C }
			</p>
			<p>
				<input type="radio" name="answer${status.index}" value="D">D.${single.option_D }
			</p>
			<hr>
		</c:forEach>
		<input type="button" value="交卷"
			onclick="go(${fn:length(list) })">
	</form>
</body>
<script type="text/javascript">
	$(function () {
		console.log('${param.paper }')
	})
	function go(length) {
		var flag = true;
		for(var i = 0 ;i<length;i++){
			if ($("input[name=answer"+i+"]:checked").val() == undefined) {
				flag = false
				break;
			}
		}
		if (flag) {
			$("form").submit();
		}else{
			alert("你还有没做的题")
		}
	}
</script>

</html>