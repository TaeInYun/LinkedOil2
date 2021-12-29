<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styles.css">
<title>회원가입성공-링크드 오일</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="header join__img">
		<a href="start.jsp"><img class="logo log__join" alt="링크드오일로고" src="images/로고.png"></a>
	</div>
	<div class="inform">
		<h3 class="inform__title">${nickname } 님</h3>
		<h4>LINKED OIL 회원가입을 환영합니다!</h4>
	</div>
	<div class="nav">
		<span><a href="login.jsp">로그인</a></span>
	</div>
		
</body>
</html>