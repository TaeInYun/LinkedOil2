<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styles.css">
<title>Log In - Linked Oil</title>
</head>
<body>
	 
	<form action="loginOK.do" method="post" class="loginForm">
			<h1>LINKED OIL</h1>
			<p><input type="text" name ="email" class="loginForm__email"  size="40" placeholder="이메일(아이디)를 입력하세요."></p>
			<p><input type="password" name ="pwd" class="loginForm__pwd" size="40" placeholder="비밀번호를 입력하세요." ></p>
			<p><input type="submit" size="60" value="로그인"></p>
			<div>
				<a href="idFind.do">아이디 찾기</a>
				<a href="signUp.jsp">회원가입</a>
				<a href="pwdFind.do">비밀번호 찾기</a>
			</div>  
	</form>
 
</body>
</html>