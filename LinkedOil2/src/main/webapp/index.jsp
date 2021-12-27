<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="search.jsp"/>
	<table>
	<c:forEach var="t" items="${list }">
		<tr>
			<td>${t.oil_name }</td>
			<td>${t.price }</td>
			<td>${t.api_diff }</td>
		</tr>
		
	</c:forEach>
	</table>
</body>
</html>