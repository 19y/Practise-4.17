<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resource/css/mystyles.css" >
<script type="text/javascript" src="resource/js/jquery-3.0.0.min.js" ></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<table>

	<tr>
		<td>编号</td>
		<td>部门</td>
		<td>上级部门</td>
	</tr>
	<c:forEach items="${list }" var="l" >
		<tr>
			<td>${l.id }</td>
			<td>${l.name }</td>
			<td>${l.sname }</td>
		</tr>
	</c:forEach>
	
	<tr>
		<td colspan="3" >
			${page}
		</td>
	</tr>
</table>

</body>
</html>