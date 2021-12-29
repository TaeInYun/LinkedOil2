<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styles.css">
<title>로그인-링크드오일</title>
</head>
<body>
	<div class="header">
		<a href="start.jsp"><img class="logo" alt="링크드오일로고" src="images/로고.png"></a>
	</div>
	<form action="loginOK.do" method="post" class="form">
		<p><input type="text" name ="email"  class="form-init" placeholder="이메일(아이디)를 입력하세요." required="required"></p>
		<p><input type="password" name ="pwd" class="form-init" placeholder="비밀번호를 입력하세요." required="required"></p>
		<p><input type="submit" class="form__submit" value="로그인"></p>
		<div class="nav">
			<a href="pwdFind.jsp">비밀번호 찾기</a>
			<a href="idFind.jsp">아이디 찾기</a>
			<a href="signUp.jsp">회원가입</a>
		</div>  
	</form>
 
</body>
</html>