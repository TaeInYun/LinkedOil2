<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>LINKED OIL</h2>
	 
	
	 
	<form action="loginOK.do" method="post">
			아이디 : <input type="text" name ="email"> <br>
			비밀번호 : <input type="password" name ="pwd"><br>
			<input type="submit" value="로그인하기"><br>
			<a href="idFind.do">아이디 찾기</a>
			<a href="pwdFind.do">비밀번호 찾기</a><br>
	</form>
 
</body>
</html>