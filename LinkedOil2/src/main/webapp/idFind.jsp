<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="css/styles.css">
 <title>아이디 찾기-Linked Oil</title>
 
</head>
<body>

	 <form action="idFind.do" method="post" class="loginForm">	
	 	<img class="logo" alt="링크드오일로고" src="images/로고.png">
		<h1>아이디 찾기</h1>	 
	 	<input type="text" size="40" name="nickName" placeholder="닉네임을 입력하세요" required="required"> <br>
		<input type="text" size="40" name="name" placeholder="이름을 입력하세요" required="required"><br>
		<input type="submit" class="loginForm__submit" value="조회">
	 </form>
	 
</body>
</html>