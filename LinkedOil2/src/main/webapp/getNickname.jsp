<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String nickname = (String)session.getAttribute("nickname");
	request.setAttribute("nickname", nickname);
	response.sendRedirect("getMyInfo.do"); 
	System.out.print(nickname + "********************");
%>
</body>
</html>