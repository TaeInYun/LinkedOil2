<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="login">
  <div class="heading">
    <h2>Sign in</h2>
    <form action="loginOK.do" method="post">

      <div class="input-group input-group-lg">
        <span class="input-group-addon"><i class="fa fa-user"></i></span>
        <input type="text" name ="email" class="form-control" placeholder="아이디를 입력하시오">
          </div>

        <div class="input-group input-group-lg">
          <span class="input-group-addon"><i class="fa fa-lock"></i></span>
          <input type="password" name ="pwd" class="form-control" placeholder="비밀번호를 입력하시오">
        </div>

        <button type="submit" value="로그인" class="float">Login</button>
        
        	<a href="idFind.do">아이디 찾기</a>
			<a href="pwdFind.do">비밀번호 찾기</a><br>
       </form>
 		</div>
 </div>
</body>
</html>

