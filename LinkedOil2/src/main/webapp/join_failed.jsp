<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styles.css">
<title>회원가입실패-링크드 오일</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="header join__img">
	<a href="start.jsp"><img class="logo log__join" alt="링크드오일로고" src="images/로고.png"></a>
	</div>
	<div class="inform">
		<h3 class="inform__title">회원가입에 실패하였습니다</h3>
		<p>존재하는 아이디 또는 닉네임 입니다.</p>
		<p class=form__msg>중복체크를 실행 후 가입해 주세요.</p>
	</div>
	<div class="nav">
		<span><a href="signUp.jsp">이전으로</a></span>
		<span><a href="start.jsp">홈으로</a></span>
	</div>
</body>
</html>