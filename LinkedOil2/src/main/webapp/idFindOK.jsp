<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="css/styles.css">
<title>아이디찾기 결과-링크드 오일</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="header join__img">
		<a href="start.jsp"><img class="logo log__join" alt="링크드오일로고" src="images/로고.png"></a>
	</div>
	<div class="inform">
		<h3 class="inform__title">아이디 찾기 결과</h3>
		<p class="inform__title">회원님의 아이디는 ${email} 입니다.</p>
	</div>
	<div class="nav">
		<span><a href="login.jsp">로그인</a></span>
		<span><a href="pwdFind.jsp">비밀번호 찾기</a></span>
	</div>
	
</body>
</html>