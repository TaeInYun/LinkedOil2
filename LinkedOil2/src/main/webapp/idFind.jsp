<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="css/styles.css">
 <title>아이디 찾기-링크드오일</title>
 
</head>
<body>
	<div class="header">
		<a href="start.jsp"><img class="logo" alt="링크드오일로고" src="images/로고.png"></a>
	</div>
	 <form action="idFind.do" method="post" class="form">	
		<h3 class="form__title">아이디 찾기</h3>	 
	 	<input type="text" class="form-init" name="nickName" placeholder="닉네임을 입력하세요" required="required"> <br>
		<input type="text" class="form-init" name="name" placeholder="이름을 입력하세요" required="required"><br>
		<input type="submit" class="form__submit" value="조회">
	 </form>
	 
</body>
</html>